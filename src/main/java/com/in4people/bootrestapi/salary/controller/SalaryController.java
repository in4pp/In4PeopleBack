package com.in4people.bootrestapi.salary.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.salary.dto.EmpSalSettingDTO;
import com.in4people.bootrestapi.salary.dto.EmployeeSalarySettingDTO;
import com.in4people.bootrestapi.salary.service.SalaryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/salary")
public class SalaryController {

    private static final Logger log = LoggerFactory.getLogger(SalaryController.class);

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }



//    @GetMapping("/monthly")
//    public ResponseEntity<ResponseDTO> selectMonthlyWage(){
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원 월급 조회 성공", salaryService.selectMonthlyWage()));
//    }



    @GetMapping("/hourlyset/{memCode}")
    public ResponseEntity<ResponseDTO> selectHourlysetMember(@PathVariable String memCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원 급여 설정 페이지 성공",  salaryService.selectHourlysetMember(memCode)));
    }

    @GetMapping("/incometax")
    public ResponseEntity<ResponseDTO> selectIncomeTax(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "소득세율 조회 성공", salaryService.selectIncomeTax()));
    }

    @GetMapping("/monthlysetting")
    public ResponseEntity<ResponseDTO> selectCalculateMonthlyWage(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "사원급여 설정 조회 성공", salaryService.selectCalculateMonthlyWage()));
    }

    @GetMapping("/salinfo")
    public ResponseEntity<ResponseDTO> selectMember(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 환경 설정을 위한 조회 성공", salaryService.selectSalinfo()));
    }

//    @GetMapping("/salinfo/game")
//    public ResponseEntity<ResponseDTO> selectMemberListAboutGame(){
//        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "급여 환경 설정을 위한 조회 성공", salaryService.selectMemberListAboutGame()));
//    }



    @Operation(summary = "사원 급여환경 설정", description = "은행, 계좌번호, 설정일 등을 설정합니다.", tags = { "SalaryController" })
    @PostMapping(("/empsalsetting"))
    public ResponseEntity<ResponseDTO> insertEmpSalSetting(@RequestBody EmployeeSalarySettingDTO employeeSalarySettingDTO){

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "설정 성공", salaryService.insertSalset(employeeSalarySettingDTO)));
    }






}
