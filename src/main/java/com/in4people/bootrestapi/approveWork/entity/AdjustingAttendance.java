package com.in4people.bootrestapi.approveWork.entity;

import com.in4people.bootrestapi.common.StringPrefixSequenceGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

import org.hibernate.annotations.Parameter;
// 근태 조정 신청 entity
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
    @Column(name = "SCHEDULE_NUMBER")
    private String scheduleNumber;       // 스케줄 번호

    @Column(name = "REPORTER_TAG_CODE")
    private String reporterTagCode;      // 상신자 태그 코드

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;       // 전자결제번호

    public AdjustingAttendance() {
    }

    public AdjustingAttendance(String adjustAttendNumber, Date adjustApplicationDate, String adjustScheduleDate, String adjustStarttime, String adjustEndtime, String adjustReason, String scheduleNumber, String reporterTagCode, String documentNumber) {
        this.adjustAttendNumber = adjustAttendNumber;
        this.adjustApplicationDate = adjustApplicationDate;
        this.adjustScheduleDate = adjustScheduleDate;
        this.adjustStarttime = adjustStarttime;
        this.adjustEndtime = adjustEndtime;
        this.adjustReason = adjustReason;
        this.scheduleNumber = scheduleNumber;
        this.reporterTagCode = reporterTagCode;
        this.documentNumber = documentNumber;
    }

    public String getAdjustAttendNumber() {
        return adjustAttendNumber;
    }

    public void setAdjustAttendNumber(String adjustAttendNumber) {
        this.adjustAttendNumber = adjustAttendNumber;
    }

    public Date getAdjustApplicationDate() {
        return adjustApplicationDate;
    }

    public void setAdjustApplicationDate(Date adjustApplicationDate) {
        this.adjustApplicationDate = adjustApplicationDate;
    }

    public String getAdjustScheduleDate() {
        return adjustScheduleDate;
    }

    public void setAdjustScheduleDate(String adjustScheduleDate) {
        this.adjustScheduleDate = adjustScheduleDate;
    }

    public String getAdjustStarttime() {
        return adjustStarttime;
    }

    public void setAdjustStarttime(String adjustStarttime) {
        this.adjustStarttime = adjustStarttime;
    }

    public String getAdjustEndtime() {
        return adjustEndtime;
    }

    public void setAdjustEndtime(String adjustEndtime) {
        this.adjustEndtime = adjustEndtime;
    }

    public String getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    public String getScheduleNumber() {
        return scheduleNumber;
    }

    public void setScheduleNumber(String scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public String getReporterTagCode() {
        return reporterTagCode;
    }

    public void setReporterTagCode(String reporterTagCode) {
        this.reporterTagCode = reporterTagCode;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "AdjustingAttendance{" +
                "adjustAttendNumber='" + adjustAttendNumber + '\'' +
                ", adjustApplicationDate=" + adjustApplicationDate +
                ", adjustScheduleDate='" + adjustScheduleDate + '\'' +
                ", adjustStarttime='" + adjustStarttime + '\'' +
                ", adjustEndtime='" + adjustEndtime + '\'' +
                ", adjustReason='" + adjustReason + '\'' +
                ", scheduleNumber='" + scheduleNumber + '\'' +
                ", reporterTagCode='" + reporterTagCode + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}


