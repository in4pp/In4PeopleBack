package com.in4people.bootrestapi.personnel.service;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.common.Criteria;
import com.in4people.bootrestapi.personnel.dto.CertificateDTO;
import com.in4people.bootrestapi.personnel.dto.PerOrderAppDTO;
import com.in4people.bootrestapi.personnel.dto.PersonnelMemberDTO;
import com.in4people.bootrestapi.personnel.entity.Certificate;
import com.in4people.bootrestapi.personnel.entity.PerOrderApp;
import com.in4people.bootrestapi.personnel.entity.PersonnelMember;
import com.in4people.bootrestapi.personnel.repository.OrderInfoRepository;
import com.in4people.bootrestapi.personnel.repository.PerMemberRepository;
import com.in4people.bootrestapi.personnel.repository.PerOrderRepository;
import com.in4people.bootrestapi.personnel.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonnelService {

    private static final Logger log = LoggerFactory.getLogger(PersonnelService.class);

    private final PersonnelRepository personnelRepository;

    private final OrderInfoRepository orderInfoRepository;

    private final PerOrderRepository perOrderRepository;

    private final ModelMapper modelMapper;
    private final PerMemberRepository perMemberRepository;


    // 테스트용 DB 출력
    public Object selectCerInfo(String cerCode) {

        Certificate certificate = personnelRepository.findByCerCode(cerCode);
        log.info("[PersonnelService] {}", certificate);

        return modelMapper.map(certificate, CertificateDTO.class);
    }

    // 페이징처리
    public int selectOrderInfoTotal() {

        log.info("[PersonnelService] selectOrderInfoTotal start ============================ ");

        List<Approval> orderInfoList = orderInfoRepository.findByDocTypeAndIsApproved("인사발령", "Y");

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
        Page<Approval> result = orderInfoRepository.findByDocTypeAndIsApproved("인사발령","Y", paging);

        List<Approval> orderInfoList = result.getContent();
        log.info("[orderInfoList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + result.getContent() );
        log.info("[PersonnelService] selectOrderInfoListWithPaging end ============================ ");

        return orderInfoList.stream().map(orderInfo -> modelMapper.map(orderInfo, Approval.class)).collect(Collectors.toList());

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
    public Object insertMemberRegist(PersonnelMemberDTO personnelMemberDTO) {

        log.info("[PersonnelService] insertMemberRegist Start ==============================");

        int result = 0;

//        java.util.Date now = new java.util.Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
//        String reviewDate = sdf.format(now);
//        perOrderAppDTO.setReviewCreateDate(perOrderAppDTO);

        try {
            PersonnelMember personnelMember = modelMapper.map(personnelMemberDTO, PersonnelMember.class);

            perMemberRepository.save(personnelMember);

            result = 1;
        } catch (Exception e) {
            log.info("[personnelMember insert] Exception!!");
        }

        log.info("[PersonnelService] insertMemberRegist End ==============================");

        return (result > 0) ? "멤버 등록 성공" : "멤버 등록 실패" ;

    }
}
