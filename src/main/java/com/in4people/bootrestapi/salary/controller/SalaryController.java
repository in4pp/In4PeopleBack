package com.in4people.bootrestapi.salary.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.salary.service.SalaryService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SalaryController {

    private static final Logger log = LoggerFactory.getLogger(SalaryController.class);

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/incomeTax")
    public ResponseEntity<ResponseDTO> selectIncomeTax(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "소득세율 조회 성공", salaryService.selectIncomeTax()));
    }

    @GetMapping("/salarysetting")
    public ResponseEntity<ResponseDTO> selectSalarySetting(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원급여 설정 조회 성공", salaryService.selectSalarySetting()));
    }
}
