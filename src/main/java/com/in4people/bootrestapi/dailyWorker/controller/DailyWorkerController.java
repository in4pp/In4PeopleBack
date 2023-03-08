package com.in4people.bootrestapi.dailyWorker.controller;

import com.in4people.bootrestapi.dailyWorker.service.DailyWorkerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class DailyWorkerController {

    private final DailyWorkerService dailyWorkerService;

    public DailyWorkerController(DailyWorkerService dailyWorkerService) {
        this.dailyWorkerService = dailyWorkerService;
    }



}
