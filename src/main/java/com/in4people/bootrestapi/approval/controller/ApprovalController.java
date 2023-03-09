package com.in4people.bootrestapi.approval.controller;

import com.in4people.bootrestapi.approval.service.ApprovalService;
import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
