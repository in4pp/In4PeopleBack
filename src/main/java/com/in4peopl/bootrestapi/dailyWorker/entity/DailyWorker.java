package com.in4peopl.bootrestapi.dailyWorker.entity;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "DAILY_WORKER")
@SequenceGenerator(    name = "DAILY_WORKER_SEQ_GENERATOR",
        sequenceName = "WORKER_CODE_SEQ",
        initialValue = 1, allocationSize = 1
)
public class DailyWorker {

    @Id
    @Column(name = "WORKER_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_WORKER_SEQ_GENERATOR")
    private int workerCode;

    @Column(name = "WORKER_NAME")
    private String workerName;

    @Column(name = "WORKER_REG_NUMBER")
    private String workerRegNumber;

    @Column(name = "WORKER_PHONE")
    private String workerPhone;

    @Column(name = "WORKER_ADDRESS")
    private String workerAddress;

    @Column(name = "CREATED_AT")
    private Date createAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

//    @ManyToOne
//    @JoinColumn(name = "SALARY_SETTING_CODE")
//    private EMPLOYEE_SALARY_SETTING employeeSalarySetting;
}
