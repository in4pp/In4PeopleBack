package com.in4people.bootrestapi.approveWork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// 전자 결제 이력 entity
@Entity
@Table(name = "DOCUMENT_APPROVAL")
public class DocumentApproval {

    @Id
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;          //전자 결제 번호 PK

    @Column(name = "APPROVED_DATE")
    private Date approvedDate;              // 승인 날짜

    @Column(name = "REASONS")
    private String reasonsRejection;        // 사유


    // FK
    @Column(name = "APPROVED__CODE")
    private String approvedCode;            // 결제 상태 코드

    @Column(name = "VACATION_NUBER")
    private String vacationNumber;          // 휴가 신청 번호

    @Column(name = "OVERTIME_NUMBER")
    private String overtimeNumber;          // 연장 근무 번호

    @Column(name = "ADJUST_ATTEND_NUMBER")
    private String adjustAttendNumber;      // 근태 조정 번호

    @Column(name = "SCHEDULE_NUMBER")
    private String scheduleNumber;          // 스케줄 번호
}
