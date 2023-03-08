package com.in4people.bootrestapi.approveWork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// 연장 근무 신청 Entity
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
    @Column(name = "MEM_CODE")
    private String memCode;                  // 사원번호

    @Column(name = "REPORTER_TAG_CODE")
    private String reporterTagCode;          // 상신자 태그 코드

    @Column(name = "WORK_SETTING_NUMBER")
    private String workSettingNumber;        // 근무 설정 번호

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;           // 전자 결제 번호

    public ApplicationOvertimeWork() {
    }

    public ApplicationOvertimeWork(String overtimeNumber, Date overtimeApplicationDate, String overtimeScheduleDate, String memCode, String reporterTagCode, String workSettingNumber, String documentNumber) {
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

    public void setOvertimeNumber(String overtimeNumber) {
        this.overtimeNumber = overtimeNumber;
    }

    public Date getOvertimeApplicationDate() {
        return overtimeApplicationDate;
    }

    public void setOvertimeApplicationDate(Date overtimeApplicationDate) {
        this.overtimeApplicationDate = overtimeApplicationDate;
    }

    public String getOvertimeScheduleDate() {
        return overtimeScheduleDate;
    }

    public void setOvertimeScheduleDate(String overtimeScheduleDate) {
        this.overtimeScheduleDate = overtimeScheduleDate;
    }

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    public String getReporterTagCode() {
        return reporterTagCode;
    }

    public void setReporterTagCode(String reporterTagCode) {
        this.reporterTagCode = reporterTagCode;
    }

    public String getWorkSettingNumber() {
        return workSettingNumber;
    }

    public void setWorkSettingNumber(String workSettingNumber) {
        this.workSettingNumber = workSettingNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "ApplicationOvertimeWork{" +
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


