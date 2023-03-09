package com.in4people.bootrestapi.approval.service;

import com.in4people.bootrestapi.approval.dto.ApprovalDTO;
import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.approval.repository.ApprovalRepository;
import com.in4people.bootrestapi.member.entity.Member;
import com.in4people.bootrestapi.member.repository.MemberRepository;
import com.in4people.bootrestapi.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApprovalService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final ApprovalRepository approvalRepository;
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;
    @Transactional
    public Object getApprovalList(String memCode) {
        log.info("[ApprovalService] getApprovalList Start =============== ");

        Member member = memberRepository.findByMemCode(memCode);

        List<Approval> approvalList = approvalRepository.findByMemCode(member);
        log.info("[ApprovalService] {}", approvalList);
        log.info("[ApprovalService] getApprovalList End =============== ");

        return approvalList.stream().map(approval -> modelMapper.map(approval, ApprovalDTO.class)).collect(Collectors.toList());
    }
}
