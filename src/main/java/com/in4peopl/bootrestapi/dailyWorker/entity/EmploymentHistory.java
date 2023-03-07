package com.in4peopl.bootrestapi.dailyWorker.entity;

import com.in4peopl.bootrestapi.dailyWorker.dto.DailyWorkDTO;
import com.in4peopl.bootrestapi.dailyWorker.dto.DailyWorkerDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYMENT_HISTORY")
public class EmploymentHistory {

//    private DailyWorkerDTO dailyWorker;
//
//    private DailyWorkDTO dailyWork;

    @Column(name = "CREATE_AT")
    private Date createAt;
}
