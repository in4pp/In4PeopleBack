package com.in4peopl.bootrestapi.dailyWorker.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerApprovalDTO {

    private int approvalCode;
    private String reason;
    private int personnelCount;
    private int bugget;
    private String department;
    private int payment;
    private Date createAt;
    private Date updatedAt;
//    private Approval approval;

}
