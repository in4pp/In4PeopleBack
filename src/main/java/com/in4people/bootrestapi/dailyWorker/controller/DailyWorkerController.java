package com.in4people.bootrestapi.dailyWorker.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkerDTO;
import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import com.in4people.bootrestapi.dailyWorker.service.DailyWorkerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class DailyWorkerController {

    private final DailyWorkerService dailyWorkerService;

    public DailyWorkerController(DailyWorkerService dailyWorkerService) {
        this.dailyWorkerService = dailyWorkerService;
    }
    @Operation(summary = "일용직사원 정보 조회 요청", description = "일용직사원 한명이 조회됩니다.", tags = { "DailyWorkerController" })
    @GetMapping("/dailyWorker/{workerCode}")
    public ResponseEntity<ResponseDTO> selectDailyWorkerInfo(@PathVariable int workerCode) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", dailyWorkerService.selectDailyWorkerInfo(workerCode)));
    }

}
