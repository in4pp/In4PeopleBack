package com.in4people.bootrestapi.dailyWorker.dto;

import com.in4people.bootrestapi.approval.entity.Approval;
import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class DailyWorkerApprovalDTO {

    private String reason;              //사유
    private int personnelCount;         //요구인원수
    private int bugget;                 //예산
    private String department;          //부서
    private int payment;                //지급액
    private Date createAt;              //생성시간
    private Date updatedAt;             //수정시간
    private Approval approval;        //결재

}
