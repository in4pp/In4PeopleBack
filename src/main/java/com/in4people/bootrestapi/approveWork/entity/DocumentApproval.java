package com.in4people.bootrestapi.approveWork.entity;



import com.in4people.bootrestapi.common.StringPrefixSequenceGenerator;
import com.in4people.bootrestapi.schedule.entity.ApplicationWorkSchedule;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

// 전자 결제 이력 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "DOCUMENT_APPROVAL")
public class DocumentApproval {


    @Id
    @Column(name = "DOCUMENT_NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCUMENT_CODE")
    @GenericGenerator(name = "SEQ_DOCUMENT_CODE", strategy = "com.in4people.bootrestapi.common.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "document")
            })
    private String documentNumber;          //전자 결제 번호 PK

    @Column(name = "APPROVED_DATE")
    private Date approvedDate;              // 승인 날짜

    @Column(name = "REASONS")
    private String reasonsRejection;        // 사유


    // FK
    @OneToOne
    @JoinColumn(name = "APPROVED__CODE")
    private ApprovedCategory approvedCode;            // 결제 상태 코드

    @ManyToOne
    @JoinColumn(name = "VACATION_NUBER")
    private ApplicationVacation vacationNumber;          // 휴가 신청 번호
    @OneToOne
    @JoinColumn(name = "OVERTIME_NUMBER")
    private  ApplicationOvertimeWork overtimeNumber;          // 연장 근무 번호

    @ManyToOne
    @JoinColumn(name = "ADJUST_ATTEND_NUMBER")
    private AdjustingAttendance adjustAttendNumber;      // 근태 조정 번호




    @ManyToOne
    @JoinColumn(name = "SCHEDULE_NUMBER")
    private ApplicationWorkSchedule scheduleNumber;          // 스케줄 번호







}
