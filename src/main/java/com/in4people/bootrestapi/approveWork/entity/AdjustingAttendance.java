package com.in4people.bootrestapi.approveWork.entity;


import com.in4people.bootrestapi.common.StringPrefixSequenceGenerator;
import com.in4people.bootrestapi.schedule.entity.ApplicationWorkSchedule;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

import org.hibernate.annotations.Parameter;
// 근태 조정 신청 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ADJUSTING_ATTENDANCE")
public class AdjustingAttendance {

    @Id
    @Column(name = "ADJUST_ATTEND_NUMBER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ATTEND_CODE")
    @GenericGenerator(name = "SEQ_ATTEND_CODE", strategy = "com.in4people.bootrestapi.common.StringPrefixSequenceGenerator",
            parameters = {
                    @Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "ATTEND")
            })
    private String adjustAttendNumber;   // 근태 조정 번호 PK

    @Column(name = "ADJUST_APPLICATION_DATE")
    private Date adjustApplicationDate;  // 신청일

    @Column(name = "ADJUST_SCHEDULE_DATE")
    private String adjustScheduleDate;   // 스케줄 적용 조정일

    @Column(name = "ADJUST_STARTTIME")
    private String adjustStarttime;      // 조정 출근시간

    @Column(name = "ADJUST_ENDTIME")
    private String adjustEndtime;        // 조정 퇴근시간

    @Column(name = "ADJUST_REASON")
    private String adjustReason;         // 조정 사유


    // FK
    @ManyToOne
    @JoinColumn(name = "SCHEDULE_NUMBER")
    private ApplicationWorkSchedule scheduleNumber;       // 스케줄 번호

    @ManyToOne
    @JoinColumn(name = "REPORTER_TAG_CODE")
    private ReporterTag reporterTagCode;      // 상신자 태그 코드

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_NUMBER")
    private DocumentApproval documentNumber;       // 전자결제번호

}


