package com.in4people.bootrestapi.dailyWorker.entity;

import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkDTO;
import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkerDTO;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYMENT_HISTORY")
@IdClass(EmploymentHistoryPk.class)
public class EmploymentHistory {

    @Id
    @Column(name = "WORKER_CODE")
    private int workCode;

    @Id
    @Column(name = "WORK_CODE")
    private int workerCode;

//    @OneToMany
//    @JoinColumn(name = "WORKER_CODE", insertable = false, updatable = false)
//    private DailyWorker dailyWorker;

    @ManyToOne
    @JoinColumn(name = "WORK_CODE", insertable = false, updatable = false)
    private DailyWork dailyWork;



}
