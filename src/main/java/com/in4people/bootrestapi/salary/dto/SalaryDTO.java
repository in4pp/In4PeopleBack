package com.in4people.bootrestapi.salary.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SalaryDTO {

    private String salaryCode;                                   // 급여항목코드
    private String salaryName;                                   // 급여명
    // 과세코드 TAXATION_CODE taxationCode NUMBER 과세테이블에서~ FK
    // 비과세코드 TAX_FREE_CODE taxFreeCode NUMBER 비과세테이블에서~ FK

}
