package com.in4people.bootrestapi.approveWork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

// 근무 스케줄 신청 entity
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
    @Column(name = "WORK_SETTING_NUMBER")
    private String workSettingNumber;      // 근무 설정 번호

    @Column(name = "MEM_CODE")
    private String memCode;                // 사원 번호

    @Column(name = "REPORTER_TAG_CODE")
    private String reporterTagCode;        // 상신자 태그 코드

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;         // 전자 결제 번호

    public ApplicationWorkSchedule() {
    }

    public ApplicationWorkSchedule(String scheduleNumber, String scheduleStartDate, Date scheduleApplicationDate, String worktypeCode, String workSettingNumber, String memCode, String reporterTagCode, String documentNumber) {
        this.scheduleNumber = scheduleNumber;
        this.scheduleStartDate = scheduleStartDate;
        this.scheduleApplicationDate = scheduleApplicationDate;
        this.worktypeCode = worktypeCode;
        this.workSettingNumber = workSettingNumber;
        this.memCode = memCode;
        this.reporterTagCode = reporterTagCode;
        this.documentNumber = documentNumber;
    }

    public String getScheduleNumber() {
        return scheduleNumber;
    }

    public void setScheduleNumber(String scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public String getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(String scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public Date getScheduleApplicationDate() {
        return scheduleApplicationDate;
    }

    public void setScheduleApplicationDate(Date scheduleApplicationDate) {
        this.scheduleApplicationDate = scheduleApplicationDate;
    }

    public String getWorktypeCode() {
        return worktypeCode;
    }

    public void setWorktypeCode(String worktypeCode) {
        this.worktypeCode = worktypeCode;
    }

    public String getWorkSettingNumber() {
        return workSettingNumber;
    }

    public void setWorkSettingNumber(String workSettingNumber) {
        this.workSettingNumber = workSettingNumber;
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "ApplicationWorkSchedule{" +
                "scheduleNumber='" + scheduleNumber + '\'' +
                ", scheduleStartDate='" + scheduleStartDate + '\'' +
                ", scheduleApplicationDate=" + scheduleApplicationDate +
                ", worktypeCode='" + worktypeCode + '\'' +
                ", workSettingNumber='" + workSettingNumber + '\'' +
                ", memCode='" + memCode + '\'' +
                ", reporterTagCode='" + reporterTagCode + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
