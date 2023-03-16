package com.in4people.bootrestapi.dailyWorker.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkerDTO;
import com.in4people.bootrestapi.dailyWorker.service.DailyWorkerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class DailyWorkerController {


    private final DailyWorkerService dailyWorkerService;
    @Autowired
    public DailyWorkerController(DailyWorkerService dailyWorkerService) {
        this.dailyWorkerService = dailyWorkerService;
    }

//    @Operation(summary = "일용직사원 한명 조회 요청", description = "일용직사원 한명이 조회됩니다.", tags = { "DailyWorkerController" })
//    @GetMapping("/dailyWorker/{workerName}")
//    public ResponseEntity<ResponseDTO> selectDailyWorkerInfo(@PathVariable String workerName) {
//
//        System.out.println("[Controller]workerName = " + workerName);
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", dailyWorkerService.selectDailyWorkerInfo(workerName)));
//    }

    @Operation(summary = "일용직사원 검색 조회 요청", description = " 검색한 일용직사원이 조회됩니다.", tags = { "DailyWorkerController" })
    @GetMapping("/dailyWorker/search/{workerName}")
    public ResponseEntity<ResponseDTO> selectDailyWorkerInfo(@PathVariable String workerName) {

        System.out.println("[Controller]workerName = " + workerName);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", dailyWorkerService.selectDailyWorkerInfo(workerName)));
    }

    @Operation(summary = "일용직사원 전체 정보 조회 요청", description = "일용직사원들이 조회됩니다.", tags = { "DailyWorkerController" })
    @GetMapping("/dailyWorker/workers")
    public ResponseEntity<ResponseDTO> selectDailyWorkerInfoAll() {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", dailyWorkerService.selectDailyWorkerInfoAll()));
    }


    @Operation(summary = "일용직사원 정보 등록 요청", description = "일용직사원 정보 등록이 진행됩니다.", tags = { "DailyWorkerController" })
    @PostMapping("/dailyWorker/insert")
    public ResponseEntity<ResponseDTO> insertDWorker(@RequestBody DailyWorkerDTO dailyWorkerDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "리뷰 입력 성공",  dailyWorkerService.insertDailyWorker(dailyWorkerDTO)));
    }


}
