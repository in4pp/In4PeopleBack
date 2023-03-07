package com.in4peopl.bootrestapi.dailyWorker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "DAILY_WORKER_APPROVAL")
public class DailyWorkerApproval {


    private String reason;

    private int personnelCount;

    private int bugget;

    private String department;

    private int payment;

    private Date createAt;

    private Date updatedAt;

//    private Approval approval;

}
