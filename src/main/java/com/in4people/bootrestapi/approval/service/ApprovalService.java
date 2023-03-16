package com.in4people.bootrestapi.approval.service;

import com.in4people.bootrestapi.approval.dto.ApprovalDTO;
import com.in4people.bootrestapi.approval.dto.BookmarkDTO;
import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.approval.entity.Bookmark;
import com.in4people.bootrestapi.approval.repository.ApprovalRepository;
import com.in4people.bootrestapi.approval.repository.BookmarkRepository;
import com.in4people.bootrestapi.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApprovalService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final ApprovalRepository approvalRepository;
    private final BookmarkRepository bookmarkRepository;
    private final ModelMapper modelMapper;
    @Transactional
    public Object getApprovalList(String memCode) {
        log.info("[ApprovalService] getApprovalList Start =============== ");

//        ApprovalMem approvalMem = approvalRepository.findByMemCode(memCode);
//        ApprovalMem mem = new ApprovalMem();
//        mem.setMemCode(memCode);

        List<Approval> approvalList = approvalRepository.getApprovalList(memCode);
        /* Date format을 분까지만. */
//        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm");
//        for(int i = 0; i < approvalList.size(); i++){
//            Date reportDate = sdf.format(approvalList.get(i).getReportDate());
//            approvalList.get(i).setReportDate(reportDate);
//        }
        log.info("[ApprovalService] {}", approvalList);
        log.info("[ApprovalService] getApprovalList End =============== ");

        return approvalList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
    }

    public Object workDocList(String docType) {
        log.info("[ApprovalService] getWorkList Start =============== ");

        List<Approval> workDocList = approvalRepository.findAllByDocType(docType);
        log.info("[ApprovalService] {}", workDocList);
        log.info("[ApprovalService] getWorkList End =============== ");

        return workDocList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
    }

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
