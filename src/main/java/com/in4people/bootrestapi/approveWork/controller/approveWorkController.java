package com.in4people.bootrestapi.approveWork.controller;

import com.in4people.bootrestapi.approveWork.service.SettingService;
import com.in4people.bootrestapi.common.ResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 연장근무/근태조정 신청 , 연장근무/근태조정/휴가신청 승인및 관리 , 전자결제 조회
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class approveWorkController {


    private final SettingService settingService;

    @GetMapping("/workManage/{workSettingNumber}")
    public ResponseEntity<ResponseDTO> selectWorkSetting(@PathVariable String workSettingNumber) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", settingService.selectWorkSetting(workSettingNumber)));
    }
}
