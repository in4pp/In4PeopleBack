package com.in4people.bootrestapi.salary.dto;

import com.in4people.bootrestapi.member.dto.MemberDTO;
import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpSalSettingDTO {

    private String salarySettingCode;
    private Member memCode;
    private String bank;
    private String accountNumber;
    private Date settingDate;



}
