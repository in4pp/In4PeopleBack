package com.in4people.bootrestapi.dailyWorker.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DAILY_WORK")
public class DailyWork {

    @Id
    @Column(name = "WORK_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_WORK_SEQ_GENERATOR")
    private int workCode;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "WORKING_TIME")
    private Date workingTime;

    @Column(name = "CREATED_AT")
    private Date createAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;
}
