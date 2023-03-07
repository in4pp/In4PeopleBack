package com.in4peopl.bootrestapi.dailyWorker.entity;

import com.in4peopl.bootrestapi.dailyWorker.dto.DailyWorkDTO;
import com.in4peopl.bootrestapi.dailyWorker.dto.DailyWorkerDTO;

import java.sql.Date;

public class EmploymentHistory {
    private DailyWorkerDTO dailyWorker;
    private DailyWorkDTO dailyWork;
    private Date createAt;
}
