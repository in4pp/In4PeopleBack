package com.in4people.bootrestapi.dailyWorker.entity;

import com.in4people.bootrestapi.approval.entity.Approval;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DAILY_WORKER_APPROVAL")

public class DailyWorkerApproval {

    @Id
    @Column(name = "APPROVAL_CODE")
    private int approvalCode;

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

    @Override
    public String toString() {
        return "DailyWorkerApproval{" +
                "approvalCode=" + approvalCode +
                ", memCode='" + memCode + '\'' +
                ", reason='" + reason + '\'' +
                ", personnelCount=" + personnelCount +
                ", bugget=" + bugget +
                ", department='" + department + '\'' +
                ", payment=" + payment +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
