package com.in4people.bootrestapi.dailyWorker.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerSalaryDTO {
    private int salaryCode;
    private int totalPayment;
    private int afterTaxIncome;
    private Date paymentDate;
    private char payCompleteYn;
    private int tax;
    private Date createAt;
    private Date updatedAt;
    private DailyWorkerAccountDTO dailyWorkerAccount;
    private DailyWorkerDTO dailyWorker;

}
