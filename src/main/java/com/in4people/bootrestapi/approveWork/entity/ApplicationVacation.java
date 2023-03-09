package com.in4people.bootrestapi.approveWork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//휴가 신청 entity
@Entity
@Table(name = "APPLICATION_VACATION")
public class ApplicationVacation {

    @Id
    @Column(name = "VACATION_NUBER")
    private String vacationNumber;          // 휴가 신청 번호 PK

    @Column(name = "VACATION_APPLICATION_DATE")
    private Date vacationApplicationDate;   // 신청일

    @Column(name = "VACATION_START_DATE")
    private Date vacationStartDate;         // 휴가 시작 기간

    @Column(name = "VACATION_END_DATE")
    private Date vacationEndDate;           // 휴가 종료 기간

    @Column(name = "VACATION_REASON")
    private String vacationReason;          // 휴가 사유

    // FK
    @Column(name = "VACATION_CODE")
    private String vacationCode;            // 휴가 코드

    @Column(name = "ALLDAY_CODE")
    private String alldayCode;              // 전일/반일 코드

    @Column(name = "REPORTER_TAG_CODE")
    private String reporterTagCode;         // 상신자 태그 코드

    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;          // 전자 결제 번호

    public ApplicationVacation() {
    }

    public ApplicationVacation(String vacationNumber, Date vacationApplicationDate, Date vacationStartDate, Date vacationEndDate, String vacationReason, String vacationCode, String alldayCode, String reporterTagCode, String documentNumber) {
        this.vacationNumber = vacationNumber;
        this.vacationApplicationDate = vacationApplicationDate;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
        this.vacationReason = vacationReason;
        this.vacationCode = vacationCode;
        this.alldayCode = alldayCode;
        this.reporterTagCode = reporterTagCode;
        this.documentNumber = documentNumber;
    }

    public String getVacationNumber() {
        return vacationNumber;
    }

    public void setVacationNumber(String vacationNumber) {
        this.vacationNumber = vacationNumber;
    }

    public Date getVacationApplicationDate() {
        return vacationApplicationDate;
    }

    public void setVacationApplicationDate(Date vacationApplicationDate) {
        this.vacationApplicationDate = vacationApplicationDate;
    }

    public Date getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(Date vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public Date getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(Date vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public String getVacationReason() {
        return vacationReason;
    }

    public void setVacationReason(String vacationReason) {
        this.vacationReason = vacationReason;
    }

    public String getVacationCode() {
        return vacationCode;
    }

    public void setVacationCode(String vacationCode) {
        this.vacationCode = vacationCode;
    }

    public String getAlldayCode() {
        return alldayCode;
    }

    public void setAlldayCode(String alldayCode) {
        this.alldayCode = alldayCode;
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
        return "ApplicationVacation{" +
                "vacationNumber='" + vacationNumber + '\'' +
                ", vacationApplicationDate=" + vacationApplicationDate +
                ", vacationStartDate=" + vacationStartDate +
                ", vacationEndDate=" + vacationEndDate +
                ", vacationReason='" + vacationReason + '\'' +
                ", vacationCode='" + vacationCode + '\'' +
                ", alldayCode='" + alldayCode + '\'' +
                ", reporterTagCode='" + reporterTagCode + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                '}';
    }
}
