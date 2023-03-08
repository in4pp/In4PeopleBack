package com.in4people.bootrestapi.approveWork.dto;

import java.util.Date;

// 근태 조정 신청 DTO
public class AdjustingAttendanceDTO {

    private String adjustAttendNumber;   // 근태 조정 번호 PK

    private Date adjustApplicationDate;  // 신청일

    private String adjustScheduleDate;   // 스케줄 적용 조정일

    private String adjustStarttime;      // 조정 출근시간

    private String adjustEndtime;        // 조정 퇴근시간

    private String adjustReason;         // 조정 사유


    // FK
    private String scheduleNumber;       // 스케줄 번호

    private String reporterTagCode;      // 상신자 태그 코드

    private String documentNumber;       // 전자결제번호

    public AdjustingAttendanceDTO() {
    }

    public AdjustingAttendanceDTO(String adjustAttendNumber, Date adjustApplicationDate, String adjustScheduleDate, String adjustStarttime, String adjustEndtime, String adjustReason, String scheduleNumber, String reporterTagCode, String documentNumber) {
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

    public Date getAdjustApplicationDate() {
        return adjustApplicationDate;
    }

    public String getAdjustScheduleDate() {
        return adjustScheduleDate;
    }

    public String getAdjustStarttime() {
        return adjustStarttime;
    }

    public String getAdjustEndtime() {
        return adjustEndtime;
    }

    public String getAdjustReason() {
        return adjustReason;
    }

    public String getScheduleNumber() {
        return scheduleNumber;
    }

    public String getReporterTagCode() {
        return reporterTagCode;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setAdjustAttendNumber(String adjustAttendNumber) {
        this.adjustAttendNumber = adjustAttendNumber;
    }

    public void setAdjustApplicationDate(Date adjustApplicationDate) {
        this.adjustApplicationDate = adjustApplicationDate;
    }

    public void setAdjustScheduleDate(String adjustScheduleDate) {
        this.adjustScheduleDate = adjustScheduleDate;
    }

    public void setAdjustStarttime(String adjustStarttime) {
        this.adjustStarttime = adjustStarttime;
    }

    public void setAdjustEndtime(String adjustEndtime) {
        this.adjustEndtime = adjustEndtime;
    }

    public void setAdjustReason(String adjustReason) {
        this.adjustReason = adjustReason;
    }

    public void setScheduleNumber(String scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public void setReporterTagCode(String reporterTagCode) {
        this.reporterTagCode = reporterTagCode;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "AdjustingAttendanceDTO{" +
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
