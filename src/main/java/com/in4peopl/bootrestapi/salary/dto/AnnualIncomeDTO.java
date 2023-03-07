package com.in4peopl.bootrestapi.salary.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AnnualIncomeDTO {

    private String annualSalaryCode;            // 연봉코드
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK
    private Date paymentYear;                   // 지급년도
    private int annualSalary;                   // 연봉
    private int realSalary;                     // 실수령연봉

}
