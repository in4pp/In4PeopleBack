package com.in4people.bootrestapi.approveWork.controller;


import com.in4people.bootrestapi.approveWork.dto.DocumentApprovalDTO;
import com.in4people.bootrestapi.approveWork.service.SettingService;
import com.in4people.bootrestapi.common.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


// (근태관리) 연장근무/근태조정 신청 , 연장근무/근태조정/휴가신청 승인및 관리 , 전자결제 조회
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ApproveWorkController {


    private final SettingService settingService;



    // 전자결제이력 조회
    @GetMapping("/document/{documentNumber}")
    public  ResponseEntity<ResponseDTO> selectDocumentApproval(@PathVariable String documentNumber) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", settingService.selectDocumentApproval(documentNumber)));
    }




    // 전자결제이력 시퀀스 문자열 생성 DB 삽입 test
    @PostMapping("/document")
    public ResponseEntity<ResponseDTO> registApprove(@RequestBody DocumentApprovalDTO newDocu) { //postman에서 넣어줌

        System.out.println("newDocu= " + newDocu);


        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "전자결제 이력 입력 성공", settingService.insertDocument(newDocu)));
    }}




