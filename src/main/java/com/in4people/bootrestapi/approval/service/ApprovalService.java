package com.in4people.bootrestapi.approval.service;

import com.in4people.bootrestapi.approval.repository.ApprovalRepository;
import com.in4people.bootrestapi.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApprovalService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final ApprovalRepository approvalRepository;
    private final ModelMapper modelMapper;
}
