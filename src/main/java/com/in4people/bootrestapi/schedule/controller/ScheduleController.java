package com.in4people.bootrestapi.schedule.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.schedule.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// (근태관리) 근무설정, 스케줄 신청, 스케줄 ,스케줄 관리, 부서별 스케줄 controller
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
 public class ScheduleController {

        private ScheduleService scheduleService;



         @GetMapping("/workManage/{workSettingNumber}")
         public ResponseEntity<ResponseDTO> selectWorkSetting(@PathVariable String workSettingNumber) {
          return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", scheduleService.selectWorkSetting(workSettingNumber)));
         }
}
