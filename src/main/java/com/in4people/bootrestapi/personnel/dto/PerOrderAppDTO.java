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

    private Long idNum; // 신청번호, PK

    private String docCode; // 문서번호

    private Date dateLeave; // 휴직일자

    private Date dateReinstatement; // 복직일자

    private Date retirementDate; // 퇴직일자

    private String applicationDepartment; // 신청부서

    private Date orderDate; // 발령일자

    private String orderDetails; // 발령내용

    private PerOrderDTO perCode; // 인사발령코드, NOT NULL

}
