package com.in4peopl.bootrestapi.dailyWorker.dto;

import lombok.*;

import java.sql.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerDTO {

    private int workerCode;
    private String workerName;
    private String workerRegNumber;
    private String workerPhone;
    private String workerAddress;
    private Date createAt;
    private Date updatedAt;
//    private EMPLOYEE_SALARY_SETTING employeeSalarySetting;




}
