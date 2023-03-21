package com.in4people.bootrestapi.schedule.entity;


import com.in4people.bootrestapi.approveWork.entity.DocumentApproval;
import com.in4people.bootrestapi.approveWork.entity.ReporterTag;
import com.in4people.bootrestapi.common.StringPrefixSequenceGenerator;
import com.in4people.bootrestapi.workState.entity.WorkMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

// 근무 스케줄 신청 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "APPLICATION_WORK_SCHEDULE")
public class ApplicationWorkScheduleDetail {

    @Id
    @Column(name = "SCHEDULE_NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SCHEDULE_CODE")
    @GenericGenerator(name = "SEQ_SCHEDULE_CODE", strategy = "com.in4people.bootrestapi.common.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "SCHEDULE")
            })
    private String scheduleNumber;         // 스케줄 번호 PK

    @Column(name = "SCHEDULE_START_DATE")
    private String scheduleStartDate;      // 스케줄 적용 시작일

    @Column(name = "SCHEDULE_APPLICATION_DATE")
    private Date scheduleApplicationDate;  // 신청일자



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

    @OneToOne
    @JoinColumn(name = "DOCUMENT_NUMBER")
    private DocumentApproval documentNumber;         // 전자 결제 번호

    @Override
    public String toString() {
        return "ApplicationWorkSchedule{" +
                "scheduleNumber='" + scheduleNumber + '\'' +
                ", scheduleStartDate='" + scheduleStartDate + '\'' +
                ", scheduleApplicationDate=" + scheduleApplicationDate +
                ", workSettingNumber=" + workSettingNumber +
                ", memCode=" + memCode +
                ", reporterTagCode=" + reporterTagCode +
                '}';
    }
}
