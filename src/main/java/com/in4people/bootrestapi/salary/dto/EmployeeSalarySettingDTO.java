package com.in4people.bootrestapi.salary.dto;

import lombok.*;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeSalarySettingDTO {

    private String salarySettingCode;                             // 급여설정코드
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK
    private String memCode;
    private String bank;                                            // 은행
    private String accountNumber;                                 // 계좌번호
    private Date settingDate;                                     // 설정일

    private int basicMonthlySalary;

    private int hourlyWage;


    // 리스트~~
    private List<MonthlyWageDTO> montlyWageList;

}
