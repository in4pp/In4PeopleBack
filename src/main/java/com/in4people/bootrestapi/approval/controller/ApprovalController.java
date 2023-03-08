package com.in4people.bootrestapi.approval.controller;

import com.in4people.bootrestapi.approval.service.ApprovalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ApprovalController {

    private final ApprovalService approvalService;


}
