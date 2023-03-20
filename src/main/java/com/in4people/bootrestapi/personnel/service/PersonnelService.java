package com.in4people.bootrestapi.personnel.service;

import com.in4people.bootrestapi.common.Criteria;
import com.in4people.bootrestapi.personnel.dto.CertificateDTO;
import com.in4people.bootrestapi.personnel.dto.PerOrderAppDTO;
import com.in4people.bootrestapi.personnel.dto.PersonnelApprovalDTO;
import com.in4people.bootrestapi.personnel.dto.PersonnelMemberDTO;
import com.in4people.bootrestapi.personnel.entity.Certificate;
import com.in4people.bootrestapi.personnel.entity.PerOrderApp;
import com.in4people.bootrestapi.personnel.entity.PersonnelApproval;
import com.in4people.bootrestapi.personnel.entity.PersonnelMember;
import com.in4people.bootrestapi.personnel.repository.PerApprovalRepository;
import com.in4people.bootrestapi.personnel.repository.PerMemberRepository;
import com.in4people.bootrestapi.personnel.repository.PerOrderRepository;
import com.in4people.bootrestapi.personnel.repository.TestRepository;
import com.in4people.bootrestapi.util.FileUploadUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonnelService {

    private static final Logger log = LoggerFactory.getLogger(PersonnelService.class);

    private final TestRepository testRepository;

    private final PerApprovalRepository perApprovalRepository;

    private final PerOrderRepository perOrderRepository;

    private final ModelMapper modelMapper;
    private final PerMemberRepository perMemberRepository;

    /* 이미지 저장 할 위치 및 응답 할 이미지 주소(WebConfig 설정파일 추가하기) */
    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

    @Autowired
    public PersonnelService(TestRepository testRepository, PerApprovalRepository perApprovalRepository, PerOrderRepository perOrderRepository, ModelMapper modelMapper, PerMemberRepository perMemberRepository){
        this.testRepository = testRepository;
        this.modelMapper = modelMapper;
        this.perApprovalRepository = perApprovalRepository;
        this.perOrderRepository = perOrderRepository;
        this.perMemberRepository = perMemberRepository;
    }

    // 테스트용 DB 출력
    public Object selectCerInfo(String cerCode) {

        Certificate certificate = testRepository.findByCerCode(cerCode);
        log.info("[PersonnelService] {}", certificate);

        return modelMapper.map(certificate, CertificateDTO.class);
    }

    // 페이징처리
    public int selectOrderInfoTotal() {

        log.info("[PersonnelService] selectOrderInfoTotal start ============================ ");

        List<PersonnelApproval> orderInfoList = perApprovalRepository.findByDocTypeAndIsApproved("인사발령", "Y");

        log.info("[PersonnelService] selectOrderInfoTotal end ============================ ");
        log.info("[orderInfoList count] >>>>>>>>>>>>> " , orderInfoList);
        return orderInfoList.size();
    }

    // 인사발령 리스트 출력
    public Object selectOrderInfoListWithPaging(Criteria cri) {

        log.info("[PersonnelService] selectOrderInfoListWithPaging start ============================ ");

        int index = cri.getPageNum() - 1;
        int count = cri.getAmount();

        Pageable paging = PageRequest.of(index, count, Sort.by("docCode").descending());
        log.info("[orderInfoList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 야호");
        Page<PersonnelApproval> result = perApprovalRepository.findByDocTypeAndIsApproved("인사발령","Y", paging);

        List<PersonnelApproval> orderInfoList = result.getContent();
        log.info("[orderInfoList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + result.getContent() );
        log.info("[PersonnelService] selectOrderInfoListWithPaging end ============================ ");

        return orderInfoList.stream().map(orderInfo -> modelMapper.map(orderInfo, PersonnelApproval.class)).collect(Collectors.toList());

    }

    // 페이징처리
    public int selectMemberTotal() {

        log.info("[PersonnelService] selectMemberTotal start ============================ ");

        List<PersonnelMember> memberList = perMemberRepository.findByIsWorking('1');

        log.info("[PersonnelService] selectMemberTotal end ============================ ");
        log.info("[memberList count] >>>>>>>>>>>>> " , memberList);
        return memberList.size();

    }

    // 멤버리스트 출력
    public Object selectMemberListWithPaging(Criteria cri) {

        log.info("[PersonnelService] selectMemberListWithPaging start ============================ ");

        int index = cri.getPageNum() - 1;
        int count = cri.getAmount();

        Pageable paging = PageRequest.of(index, count, Sort.by("memCode").descending());
        log.info("[memberList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 야호");
        Page<PersonnelMember> result = perMemberRepository.findByIsWorking('1', paging);

        List<PersonnelMember> memberList = result.getContent();
        log.info("[memberList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + result.getContent() );
        log.info("[PersonnelService] selectMemberListWithPaging end ============================ ");

        return memberList.stream().map(memList -> modelMapper.map(memList, PersonnelMember.class)).collect(Collectors.toList());

    }

    // 인사발령 등록
    @Transactional
    public Object insertOrderApp(PerOrderAppDTO perOrderAppDTO) {
        log.info("[PersonnelService] insertOrderApp Start ==============================");

        int result = 0;

//        java.util.Date now = new java.util.Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
//        String reviewDate = sdf.format(now);
//        perOrderAppDTO.setReviewCreateDate(perOrderAppDTO);

        try {
            PerOrderApp perOrderApp = modelMapper.map(perOrderAppDTO, PerOrderApp.class);

            perOrderRepository.save(perOrderApp);

            result = 1;
        } catch (Exception e) {
            log.info("[perOrderApp insert] Exception!!");
        }

        log.info("[PersonnelService] insertOrderApp End ==============================");

        return (result > 0) ? "인사발령 등록 성공" : "인사발령 등록 실패" ;
    }

    // 멤버 등록
    @Transactional
    public Object insertMemberRegist(PersonnelMemberDTO personnelMemberDTO, MultipartFile imgs) {

        log.info("[PersonnelService] insertMemberRegist Start ==============================");
        log.info("[PersonnelService] PersonnelMemberDTO : " + personnelMemberDTO);

        String imageName = UUID.randomUUID().toString().replace("-", "");
        String replaceFileName = null;
        int result = 0;

        try {

            /* util 패키지에 FileUploadUtils 추가 */
            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, imgs);

            personnelMemberDTO.setMemPic(replaceFileName);

            log.info("[PersonnelService] insert Image Name : ", replaceFileName);

            PersonnelMember personnelMember = modelMapper.map(personnelMemberDTO, PersonnelMember.class);

            log.info("[PersonnelService] personnelMember : ", personnelMember);

            perMemberRepository.save(personnelMember);

            result = 1;
        } catch (Exception e) {
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        log.info("[PersonnelService] insertMemberRegist End ==============================");

        return (result > 0) ? "멤버 등록 성공" : "멤버 등록 실패" ;

    }

    // 증명서 신청 등록
    public Object insertcerApp(PersonnelApprovalDTO personnelApprovalDTO) {

        log.info("[PersonnelService] insertcerApp Start ==============================");

        int result = 0;

//        java.util.Date now = new java.util.Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
//        String reviewDate = sdf.format(now);
//        perOrderAppDTO.setReviewCreateDate(perOrderAppDTO);

        try {
            PersonnelApproval personnelApproval = modelMapper.map(personnelApprovalDTO, PersonnelApproval.class);

            perApprovalRepository.save(personnelApproval);

            result = 1;
        } catch (Exception e) {
            log.info("[personnelApproval insert] Exception!!");
        }

        log.info("[PersonnelService] insertcerApp End ==============================");

        return (result > 0) ? "증명서 신청 등록 성공" : "증명서 신청 등록 실패" ;

    }

    // 맴버들끼리 서로 조회할 수 있는 상세 페이지 조회
    public Object selectMemberDetail(String memCode) {

        log.info("[PersonnelService] getMemberDetail Start ==============================");

        PersonnelMember member = perMemberRepository.findById(memCode).get();
        member.setMemPic(IMAGE_URL + member.getMemPic());

        log.info("[PersonnelService] getMemberDetail End ==============================");

        return modelMapper.map(member, PersonnelMember.class);

    }


    //  인사정보 수정하기 위한 select
    public Object selectMemberUpdate(String memCode) {

        log.info("[PersonnelService] getMemberDetail Start ==============================");

        PersonnelMember member = perMemberRepository.findById(memCode).get();
        member.setMemPic(IMAGE_URL + member.getMemPic());

        log.info("[PersonnelService] getMemberDetail End ==============================");

        PersonnelMemberDTO personnelMemberDTO = modelMapper.map(member, PersonnelMemberDTO.class);
        return personnelMemberDTO;
    }

    // 멤버 정보 수정
    @Transactional
    public Object updateMember(PersonnelMemberDTO personnelMemberDTO, MultipartFile imgs) {

        log.info("[PersonnelService] updateMember Start ==============================");
        log.info("[PersonnelService] PersonnelMemberDTO : " + personnelMemberDTO);

        String replaceFileName = null;
        int result = 0;

        try {

            /* update 할 엔티티 조회 */
            PersonnelMember member = perMemberRepository.findById(personnelMemberDTO.getMemCode()).get();
            String oriImage = member.getMemPic();
            log.info("[updateMember] oriImage : " + oriImage);

            /* update를 위한 엔티티 값 수정 */
            member.setMemName(personnelMemberDTO.getMemName());
            member.setPassword(personnelMemberDTO.getPassword());
            member.setRegiNumber(personnelMemberDTO.getRegiNumber());
            member.setGender(personnelMemberDTO.getGender());
            member.setPhone(personnelMemberDTO.getPhone());
            member.setEmail(personnelMemberDTO.getEmail());
            member.setNationality(personnelMemberDTO.getNationality());
            member.setIsMarried(personnelMemberDTO.getIsMarried());
            member.setAddress(personnelMemberDTO.getAddress()); // 어떻게바꾸지

            if(imgs != null){
                String imageName = UUID.randomUUID().toString().replace("-", "");
                replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, imgs);
                log.info("[updateMember] InsertFileName : " + replaceFileName);

                member.setMemPic(replaceFileName);	// 새로운 파일 이름으로 update
                log.info("[updateMember] deleteImage : " + oriImage);

                boolean isDelete = FileUploadUtils.deleteFile(IMAGE_DIR, oriImage);
                log.info("[update] isDelete : " + isDelete);
            } else {

                /* 이미지 변경 없을 시 */
                member.setMemPic(oriImage);
            }

            result = 1;
        } catch (IOException e) {
            log.info("[updateMember] Exception!!");
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }
        log.info("[PersonnelService] updateMember End ===================================");
        return (result > 0) ? "멤버 업데이트 성공" : "멤버 업데이트 실패";
    }
}
