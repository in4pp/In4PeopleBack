package com.in4people.bootrestapi.schedule.entity;

import com.in4people.bootrestapi.approveWork.entity.DocumentApproval;
import com.in4people.bootrestapi.approveWork.entity.ReporterTag;

import com.in4people.bootrestapi.workState.entity.WorkMember;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

// 근무 스케줄 신청 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "APPLICATION_WORK_SCHEDULE")
public class ApplicationWorkSchedule {

    @Id
    @Column(name = "SCHEDULE_NUMBER")
    private String scheduleNumber;         // 스케줄 번호 PK

    @Column(name = "SCHEDULE_START_DATE")
    private String scheduleStartDate;      // 스케줄 적용 시작일

    @Column(name = "SCHEDULE_APPLICATION_DATE")
    private Date scheduleApplicationDate;  // 신청일자

    @Column(name = "WORKTYPE_CODE")
    private String worktypeCode;           // 근무 유형 코드

    // FK
    @ManyToOne
    @JoinColumn(name = "WORK_SETTING_NUMBER")
    private WorkSetting workSettingNumber;      // 근무 설정 번호

    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private WorkMember memCode;                // 사원 번호

    @ManyToOne
    @JoinColumn(name = "REPORTER_TAG_CODE")
    private ReporterTag reporterTagCode;        // 상신자 태그 코드

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_NUMBER")
    private DocumentApproval documentNumber;         // 전자 결제 번호



}
