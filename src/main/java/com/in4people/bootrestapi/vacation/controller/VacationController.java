package com.in4people.bootrestapi.vacation.controller;


import com.in4people.bootrestapi.vacation.service.VacationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// (근태관리) 연차생성, 휴가신청, 휴가 사용 현황 컨트롤러
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class VacationController {

    private final VacationService vacationService;
}
