package com.in4peopl.bootrestapi.dailyWorker.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DAILY_WORKER_ACCOUNT")
@SequenceGenerator(	name = "DAILY_WORKER_ACCOUNT_SEQ_GENERATOR",
        sequenceName = "SEQ_ACCOUNT_CODE",
        initialValue = 1, allocationSize = 1
)
public class DailyWorkerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_WORKER_ACCOUNT_SEQ_GENERATOR")
    private int accountCode;

    private String accountHolder;

    private Date updatedAt;

//    private EmployeeSalarySettingDTO employeeSalarySetting;

}


