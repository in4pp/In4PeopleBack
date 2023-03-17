package com.in4people.bootrestapi.schedule.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.schedule.dto.WorkSettingDTO;
import com.in4people.bootrestapi.schedule.dto.WorkSettingUpDTO;
import com.in4people.bootrestapi.schedule.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// (근태관리) 근무설정, 스케줄 신청, 스케줄 ,스케줄 관리, 부서별 스케줄 controller
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
 public class ScheduleController {

        private ScheduleService scheduleService;

        private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);

         @Operation(summary = "기본 근무 설정 조회 요청 ", description = "기본 근무 설정 정보가 조회됩니다.", tags = {"ScheduleController"})
         @GetMapping("/workmanage/setting") // 기본 근무설정 불러오기
         public ResponseEntity<ResponseDTO> selectWorkSetting(){
          return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", scheduleService.selectWorkSetting()));
         }

         @Operation(summary = "기본 근무 설정 수정하기", description = "기본 근무 설정 정보가 수정됩니다.", tags = { "ScheduleController"})
         @PutMapping("/workmanage/setting") // 기본 근무 수정하기
         public ResponseEntity<ResponseDTO> updateWorkSetting(@RequestBody WorkSettingUpDTO workSettingUpDTO){

          log.info("workSettingUpDTO : " ,workSettingUpDTO);

          log.info("[WorkSetting Controller] workSettingDTO.getDay1():" + workSettingUpDTO.getDay1());




          return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "기본근무 설정 수정 성공", scheduleService.updateWorkSetting(workSettingUpDTO)));
         }

}
