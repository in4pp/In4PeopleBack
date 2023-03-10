package com.in4people.bootrestapi.personnel.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PerOrderAppDTO {

    // 인사발령신청

    // 결재 FK, NOT NULL
//    private String docCode; // 문서번호
//
//    private String memCode; // 사원번호

    private Date dateLeave; // 휴직일자

    private Date dateReinstatement; // 복직일자

    private Date retirementDate; // 퇴직일자

    private String applicationDepartment; // 신청부서

    private Date orderDate; // 발령일자


    private PerOrderDTO perCode; // 인사발령코드, FK, NOT NULL

}
