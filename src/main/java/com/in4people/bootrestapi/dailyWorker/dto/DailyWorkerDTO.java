package com.in4people.bootrestapi.dailyWorker.dto;

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
    private DailyWorkerAccountDTO dailyWorkerAccount;




}
