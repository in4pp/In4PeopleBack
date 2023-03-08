package com.in4people.bootrestapi.approval.dto;

import com.in4people.bootrestapi.member.dto.MemberDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApprovalDTO {

    private String docCode;
    private MemberDTO memberDTO; //
    private MemberDTO memCode; //FK+PK 상신인
    private char isApproved; // W/Y/N

}
