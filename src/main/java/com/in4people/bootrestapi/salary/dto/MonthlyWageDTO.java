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
    private String monthlyPaycheck;                         // 월급
    private int netSalary;                                  // 실수령액
    private Date paymentDate;                               // 지급일
    private int bonusSUM;                                   // 상여금합계

}
