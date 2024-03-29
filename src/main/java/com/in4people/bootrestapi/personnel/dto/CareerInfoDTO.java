package com.in4people.bootrestapi.personnel.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CareerInfoDTO {

    // 경력정보
    private Long careerNumber; // 경력번호, PK, NOT NULL

    private String corporateName; // 회사명

    private Date enteringDate; // 입사일자

    private Date retirementDate; // 퇴직일자

    private String position; // 직급

    private String workingDepartment; // 근무부서

    private String reasonsRetirement; // 퇴직사유

    private PersonnelMemberDTO memCode; // 사원번호 FK, NOT NULL

}
