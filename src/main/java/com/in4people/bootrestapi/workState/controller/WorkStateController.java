package com.in4people.bootrestapi.workState.controller;


// (근태관리) 일일근태등록, 월간근태 controller

import com.in4people.bootrestapi.workState.service.WorkStateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class WorkStateController {

    private final WorkStateService workStateService;
}
