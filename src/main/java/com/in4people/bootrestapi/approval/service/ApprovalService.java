package com.in4people.bootrestapi.approval.service;

import com.in4people.bootrestapi.approval.dto.*;
import com.in4people.bootrestapi.approval.entity.*;
import com.in4people.bootrestapi.approval.paging.CriteriaAP;
import com.in4people.bootrestapi.approval.repository.*;
import com.in4people.bootrestapi.member.repository.MemberRepository;
import com.in4people.bootrestapi.member.service.MemberService;
import com.in4people.bootrestapi.util.FileUploadUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApprovalService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final ApprovalRepository approvalRepository;
    private final BookmarkRepository bookmarkRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final InsertApprovalRepository insertApprovalRepository;
    private final DocAttachmentRepository docAttachmentRepository;

    @PersistenceContext
    EntityManager em;

    public String changeSearchDate(String inputDate) {
        /* 입력 날짜 + 1을 위한 메소드 */
        String YYMMDD = inputDate.substring(2); // YY/MM/DD

        String day = YYMMDD.substring(6);
        String YYDD = YYMMDD.substring(0, 6); // YY/MM/ 까지
        int intDay = Integer.parseInt(day) + 1;
        if (intDay < 10) {
            day = "0" + intDay;
        } else {
            day = "" + intDay;
        }

        String date = (YYDD += day); // YY/MM/DD
        System.out.println("수정된 endDate ========== " + date);

        return date;
    }

    public int getApprovalList(String memCode) {
        /* total을 구하기 위한 메소드 */

        int result = approvalRepository.getApprovalList(memCode).size();

        return result;
    }

    @Transactional
    public List<ApprovalDTO> getApprovalList(String memCode, CriteriaAP cri) {
        log.info("[ApprovalService] getApprovalList Start =============== ");

        int index = cri.getPageNum() - 1;
        int count = cri.getAmount(); // 현재 페이지
        Pageable paging = PageRequest.of(index, count, Sort.by("docCode").descending());
        Page<Approval> result = approvalRepository.getApprovalList(memCode, paging);
        List<Approval> approvalList = (List<Approval>) result.getContent();


//        List<Approval> approvalList = approvalRepository.getApprovalList(memCode);
        log.info("[ApprovalService] {}", approvalList);
        log.info("[ApprovalService] getApprovalList End =============== ");

        return approvalList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
    }

    public Object getSearchApproval(String memCode, String startDate1, String endDate1) {
        log.info("[ApprovalService] getSearchApproval Start =============== ");

        String startDate = changeSearchDate(startDate1);
        String endDate = changeSearchDate(endDate1);

        System.out.println("startDate = " + startDate);
        System.out.println("endDate = " + endDate);

        List<Approval> approvalList = approvalRepository.getSearchApproval(memCode, startDate, endDate);
        System.out.println("approvalList = " + approvalList);

        return approvalList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
    }

    public Object getSearchInfoAPI(String nameOrPosition, String inputValue) {
        log.info("[ApprovalService] getSearchInfoAPI Start =============== ");
        System.out.println("nameOrPosition = " + nameOrPosition);
        System.out.println("inputValue = " + inputValue);

        List<ApprovalMem> foundMembers = null;
        if (nameOrPosition.equals("이름")) {
            foundMembers = memberRepository.getSearchInfoByName(inputValue);
        } else if (nameOrPosition.equals("직급")) {
            foundMembers = memberRepository.getSearchInfoByPosition(inputValue);
        }

        return foundMembers.stream().map(member -> modelMapper.map(member, ApprovalMemDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    public Object postApprovalBookmark(BookmarkDTO bookmarkDTO) {
        log.info("[ApprovalService] postApprovalBookmark Start ============================= ");

        int result = 0;

        try {

            Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);

            bookmarkRepository.save(bookmark);

            result = 1;
        } catch (Exception e) {
            log.info("[bookmark insert] Failed!!");
        }

        log.info("[ApprovalService] postApprovalBookmark End ==============================");

        return (result > 0) ? "북마크 등록" : "북마크 등록 실패";
    }

    public Object deleteApprovalBookmark(BookmarkDTO bookmarkDTO) {

        int result = 0;

        try {
            Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);

            bookmarkRepository.delete(bookmark);

            result = 1;
        } catch (Exception e) {
            log.info("[bookmark delete ] Failed!!");
        }
        log.info("[ApprovalService] postApprovalBookmark End ==============================");

        return (result > 0) ? "북마크 삭제" : "북마크 삭제 실패";
    }


    @Transactional
    public Object insertApproval(InsertApprovalDTO insertApprovalDTO) {

        System.out.println("Service ====== insertApprovalDTO = " + insertApprovalDTO);

        int result = 0;
        String docCode = "";

        try {

            InsertApproval insertApproval = modelMapper.map(insertApprovalDTO, InsertApproval.class);
            List<Approver> approverList = insertApproval.getApproverList();
            List<Referee> refereeList = insertApproval.getRefereeList();
            insertApproval.setApproverList(null);
            insertApproval.setRefereeList(null);

            System.out.println("refereeList ========== " + refereeList);
            System.out.println("approverList ========== " + approverList);

            insertApprovalRepository.save(insertApproval);
            System.out.println("insertApproval = " + insertApproval);

            if (approverList != null) {
                for (int i = 0; i < approverList.size(); i++) {

                    Approver approver = approverList.get(i);
                    String sql = "INSERT INTO APPROVER (DOC_CODE, MEM_CODE) VALUES (:value1, :value2)";
                    Query nativeQuery = em.createNativeQuery(sql);
                    nativeQuery.setParameter("value1", insertApproval.getDocCode());
                    nativeQuery.setParameter("value2", approver.getMemCode());
                    nativeQuery.executeUpdate();
                }
            }

            if (refereeList != null) {
                for (int i = 0; i < refereeList.size(); i++) {

                    Referee referee = refereeList.get(i);
                    String sql = "INSERT INTO REFEREE (DOC_CODE, MEM_CODE) VALUES (:value1, :value2)";
                    Query nativeQuery = em.createNativeQuery(sql);
                    nativeQuery.setParameter("value1", insertApproval.getDocCode());
                    nativeQuery.setParameter("value2", referee.getMemCode());
                    nativeQuery.executeUpdate();
                }
            }

            result = 1;
            docCode = insertApproval.getDocCode();
        } catch (Exception e) {
            log.info("[Approval insert] Failed!!");
        }


        log.info("[ApprovalService] insertApproval End ==============================");

        return (result > 0) ? docCode : "실패";
    }

    @Transactional
    public Object insertApprovalDoc(List<MultipartFile> docAttachments, String docCode) {

        System.out.println("Service ====== insertApprovalDoc = " + docAttachments);
        List<DocAttachment> docAttachmentList = new ArrayList<>();
        String DOC_URL = "src/main/resources/static/imgs/attachments";


        String savedName = null; // 실제저장될이름(+.확장자포함)
        int result = 0;

        /* util 패키지에 FileUploadUtils 추가 */
        try {
            for (MultipartFile file : docAttachments) {

                String imageName = UUID.randomUUID().toString().replace("-", "");
                savedName = FileUploadUtils.saveFile(DOC_URL, imageName, file);
                savedName = "/imgs/attachments/" + savedName;
                System.out.println("savedName = " + savedName);

            DocAttachment docAttachment = new DocAttachment();
            docAttachment.setUrl(savedName); // 저장경로 + 저장이름(+.확장자)
            docAttachment.setDocCode(docCode);
            docAttachment.setFileName(file.getOriginalFilename()); // 찐이름

            docAttachmentList.add(docAttachment);
            }
            System.out.println("docAttachmentList = " + docAttachmentList);
            docAttachmentRepository.saveAll(docAttachmentList);

            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return (result > 0) ? "등록성공" : "등록 실패" ;
    }
}
