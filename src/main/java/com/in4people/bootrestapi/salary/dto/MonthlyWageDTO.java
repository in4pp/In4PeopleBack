package com.in4people.bootrestapi.salary.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MonthlyWageDTO {

    private String monthlyWageCode;                         // 월급코드
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK
//    private String memCode;
    private int monthlyPaycheck;                         // 월급
    private double netSalary;                                  // 실수령액
    private Date paymentDate;                               // 지급일
    private int bonusSUM;                                   // 상여금합계

    private int totalSum;
    private double nationalPension;
    private double healthInsurance;
    private double employmentInsurance;
    private double incomeTax1;
    private double incomeTax2;

    private String salarySettingCode;



}
