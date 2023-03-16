package com.in4people.bootrestapi.approval.controller;

import com.in4people.bootrestapi.approval.dto.BookmarkDTO;
import com.in4people.bootrestapi.approval.service.ApprovalService;
import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ApprovalController {

    private final ApprovalService approvalService;

    @Operation(summary = "결재 상신함 문서 목록", description = "상신 문서리스트", tags = { "ApprovalController" })
    @GetMapping("/approval/{memCode}")
    public ResponseEntity<ResponseDTO> getApprovalList(@PathVariable String memCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", approvalService.getApprovalList(memCode)));
    }

//    @Operation(summary = "결재 문서 목록 테스트", description = "업무 문서리스트 테스트", tags = { "ApprovalController" })
//    @GetMapping("/approval/{docType}")
//    public ResponseEntity<ResponseDTO> workDocList(@RequestParam String docType){
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", approvalService.workDocList(docType)));
//    }

    @Operation(summary = "결재 북마크 등록", description = "결재 북마크 수정", tags = { "ApprovalController" })
    @PostMapping("/approval/bookmark/post")
    public ResponseEntity<ResponseDTO> postApprovalBookmark(@RequestBody BookmarkDTO bookmarkDTO){
        System.out.println("bookmarkDTO = " + bookmarkDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "등록 성공", approvalService.postApprovalBookmark(bookmarkDTO)));
    }

    @Operation(summary = "결재 북마크 삭제", description = "결재 북마크 삭제", tags = { "ApprovalController" })
    @DeleteMapping("/approval/bookmark/delete")
    public ResponseEntity<ResponseDTO> deleteApprovalBookmark(@RequestBody BookmarkDTO bookmarkDTO){

        System.out.println("Delete bookmarkDTO = " + bookmarkDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "삭제 성공", approvalService.deleteApprovalBookmark(bookmarkDTO)));
    }
}
