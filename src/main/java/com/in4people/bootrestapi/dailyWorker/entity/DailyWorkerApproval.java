package com.in4people.bootrestapi.dailyWorker.entity;

import com.in4people.bootrestapi.approval.entity.Approval;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DAILY_WORKER_APPROVAL")
@IdClass(DailyWorkerApprovalPk.class)
public class DailyWorkerApproval {

    @Id
    @Column(name = "DOC_CODE")
    private String docCode;

    @Id
    @Column(name = "MEM_CODE")
    private String memCode;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "PERSONNEL_COUNT")
    private int personnelCount;

    @Column(name = "BUGGET")
    private int bugget;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "PAYMENT")
    private int payment;

    @Column(name = "CREATED_AT")
    private Date createAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "DOC_CODE", insertable = false, updatable = false)
    private Approval approval;
}
