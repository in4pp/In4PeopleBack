package com.in4people.bootrestapi.approval.service;

import com.in4people.bootrestapi.approval.dto.ApprovalDTO;
import com.in4people.bootrestapi.approval.dto.BookmarkDTO;
import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.approval.entity.Bookmark;
import com.in4people.bootrestapi.approval.paging.CriteriaAP;
import com.in4people.bootrestapi.approval.repository.ApprovalRepository;
import com.in4people.bootrestapi.approval.repository.BookmarkRepository;
import com.in4people.bootrestapi.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.hibernate.type.descriptor.java.DateTypeDescriptor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApprovalService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final ApprovalRepository approvalRepository;
    private final BookmarkRepository bookmarkRepository;
    private final ModelMapper modelMapper;

    public String changeSearchDate(String inputDate){
        /* 입력 날짜 + 1을 위한 메소드 */
        String YYMMDD = inputDate.substring(2); // YY/MM/DD

        String day = YYMMDD.substring(6);
        String YYDD = YYMMDD.substring(0,6); // YY/MM/ 까지
        int intDay = Integer.parseInt(day) + 1;
        if(intDay < 10){
            day = "0" + intDay;
        } else{
            day = "" + intDay;
        }

        String date = (YYDD += day); // YY/MM/DD
        System.out.println("수정된 endDate ========== " + date);

        return date;
    }
    public int getApprovalList(String memCode) {
        log.info("[ApprovalService] getApprovalList Start =============== ");

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
        List<Approval> approvalList = (List<Approval>)result.getContent();


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

        List<Approval> approvalList = approvalRepository.getSearchApproval(memCode,startDate, endDate);
        System.out.println("approvalList = " + approvalList);

        return approvalList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
    }

//    public Object workDocList(String docType) {
//        log.info("[ApprovalService] getWorkList Start =============== ");
//
//        List<Approval> workDocList = approvalRepository.findAllByDocType(docType);
//        log.info("[ApprovalService] {}", workDocList);
//        log.info("[ApprovalService] getWorkList End =============== ");
//
//        return workDocList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
//    }

    @Transactional
    public Object postApprovalBookmark(BookmarkDTO bookmarkDTO) {
        log.info("[ApprovalService] postApprovalBookmark Start ============================= " );

        int result = 0;

        try{

            Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);

            bookmarkRepository.save(bookmark);

            result = 1;
        } catch (Exception e){
            log.info("[bookmark insert] Failed!!");
        }

        log.info("[ApprovalService] postApprovalBookmark End ==============================");

        return (result > 0) ? "북마크 등록" : "북마크 등록 실패";
    }

    public Object deleteApprovalBookmark(BookmarkDTO bookmarkDTO) {

        int result = 0;

        try{
            Bookmark bookmark = modelMapper.map(bookmarkDTO, Bookmark.class);

            bookmarkRepository.delete(bookmark);

            result = 1;
        } catch (Exception e){
            log.info("[bookmark delete ] Failed!!");
        }
        log.info("[ApprovalService] postApprovalBookmark End ==============================");
        
        return (result > 0) ? "북마크 삭제" : "북마크 삭제 실패";
    }



}
