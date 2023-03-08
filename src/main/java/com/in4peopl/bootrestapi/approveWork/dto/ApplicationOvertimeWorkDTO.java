package com.in4peopl.bootrestapi.approveWork.dto;

import java.util.Date;

// 연장 근무 신청 DTO (양방향)
public class ApplicationOvertimeWorkDTO {

    private String overtimeNumber;           // 연장 근무 번호 PK

    private Date overtimeApplicationDate;    // 신청일

    private String overtimeScheduleDate;     // 연장 근무 적용일 + 시간


    //FK
    private String memCode;                  // 사원번호

    private String reporterTagCode;          // 상신자 태그 코드

    private String workSettingNumber;        // 근무 설정 번호

    private String documentNumber;           // 전자 결제 번호


    public ApplicationOvertimeWorkDTO() {
    }

    public ApplicationOvertimeWorkDTO(String overtimeNumber, Date overtimeApplicationDate, String overtimeScheduleDate, String memCode, String reporterTagCode, String workSettingNumber, String documentNumber) {
        this.overtimeNumber = overtimeNumber;
        this.overtimeApplicationDate = overtimeApplicationDate;
        this.overtimeScheduleDate = overtimeScheduleDate;
        this.memCode = memCode;
        this.reporterTagCode = reporterTagCode;
        this.workSettingNumber = workSettingNumber;
        this.documentNumber = documentNumber;
    }

    public String getOvertimeNumber() {
        return overtimeNumber;
    }

    public Date getOvertimeApplicationDate() {
        return overtimeApplicationDate;
    }

    public String getOvertimeScheduleDate() {
        return overtimeScheduleDate;
    }

    public String getMemCode() {
        return memCode;
    }

    public String getReporterTagCode() {
        return reporterTagCode;
    }

    public String getWorkSettingNumber() {
        return workSettingNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setOvertimeNumber(String overtimeNumber) {
        this.overtimeNumber = overtimeNumber;
    }

    public void setOvertimeApplicationDate(Date overtimeApplicationDate) {
        this.overtimeApplicationDate = overtimeApplicationDate;
    }

    public void setOvertimeScheduleDate(String overtimeScheduleDate) {
        this.overtimeScheduleDate = overtimeScheduleDate;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    public void setReporterTagCode(String reporterTagCode) {
        this.reporterTagCode = reporterTagCode;
    }

    public void setWorkSettingNumber(String workSettingNumber) {
        this.workSettingNumber = workSettingNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "ApplicationOvertimeWorkDTO{" +
                "overtimeNumber='" + overtimeNumber + '\'' +
                ", overtimeApplicationDate=" + overtimeApplicationDate +
                ", overtimeScheduleDate='" + overtimeScheduleDate + '\'' +
                ", memCode='" + memCode + '\'' +
                ", reporterTagCode='" + reporterTagCode + '\'' +
                ", workSettingNumber='" + workSettingNumber + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
