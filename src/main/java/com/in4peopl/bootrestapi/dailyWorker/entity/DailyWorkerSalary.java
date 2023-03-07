package com.in4peopl.bootrestapi.dailyWorker.entity;

import com.in4peopl.bootrestapi.dailyWorker.dto.DailyWorkerAccountDTO;
import com.in4peopl.bootrestapi.dailyWorker.dto.DailyWorkerDTO;

import java.sql.Date;

public class DailyWorkerSalary {
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
