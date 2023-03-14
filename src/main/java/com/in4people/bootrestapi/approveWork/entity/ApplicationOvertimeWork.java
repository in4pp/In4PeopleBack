package com.in4people.bootrestapi.approveWork.entity;


import com.in4people.bootrestapi.schedule.entity.WorkSetting;
import com.in4people.bootrestapi.workState.entity.WorkMember;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

// 연장 근무 신청 Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "APPLICATION_OVERTIME_WORK")
public class ApplicationOvertimeWork {

    @Id
    @Column(name = "OVERTIME_NUMBER")
    private String overtimeNumber;           // 연장 근무 번호 PK

    @Column(name = "OVERTIME_APPLICATION_DATE")
    private Date overtimeApplicationDate;    // 신청일

    @Column(name = "OVERTIME_SCHEDULE_DATE")
    private String overtimeScheduleDate;     // 연장 근무 적용일 + 시간


    //FK
    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private WorkMember memCode;                  // 사원번호

    @ManyToOne
    @JoinColumn(name = "REPORTER_TAG_CODE")
    private ReporterTag reporterTagCode;          // 상신자 태그 코드

    @ManyToOne
    @JoinColumn(name = "WORK_SETTING_NUMBER")
    private WorkSetting workSettingNumber;        // 근무 설정 번호

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_NUMBER")
    private DocumentApproval documentNumber;           // 전자 결제 번호

}


