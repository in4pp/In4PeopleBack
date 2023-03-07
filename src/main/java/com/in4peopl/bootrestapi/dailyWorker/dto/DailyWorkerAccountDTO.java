package com.in4peopl.bootrestapi.dailyWorker.dto;

import lombok.*;
import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerAccountDTO {

    private int accountCode;
    private String accountHolder;
    private Date updatedAt;
//    private EmployeeSalarySettingDTO employeeSalarySetting;
}
