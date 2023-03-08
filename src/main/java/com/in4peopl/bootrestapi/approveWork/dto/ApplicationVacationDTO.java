package com.in4peopl.bootrestapi.approveWork.dto;

import java.util.Date;

// 휴가 신청 DTO (양방향)
public class ApplicationVacationDTO {

    private String vacationNumber;          // 휴가 신청 번호 PK

    private Date vacationApplicationDate;   // 신청일

    private Date vacationStartDate;         // 휴가 시작 기간

    private Date vacationEndDate;           // 휴가 종료 기간

    private String vacationReason;          // 휴가 사유

    // FK
    private String vacationCode;            // 휴가 코드

    private String alldayCode;              // 전일/반일 코드

    private String reporterTagCode;         // 상신자 태그 코드

    private String documentNumber;          // 전자 결제 번호

    public ApplicationVacationDTO() {
    }

    public ApplicationVacationDTO(String vacationNumber, Date vacationApplicationDate, Date vacationStartDate, Date vacationEndDate, String vacationReason, String vacationCode, String alldayCode, String reporterTagCode, String documentNumber) {
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

    public Date getVacationApplicationDate() {
        return vacationApplicationDate;
    }

    public Date getVacationStartDate() {
        return vacationStartDate;
    }

    public Date getVacationEndDate() {
        return vacationEndDate;
    }

    public String getVacationReason() {
        return vacationReason;
    }

    public String getVacationCode() {
        return vacationCode;
    }

    public String getAlldayCode() {
        return alldayCode;
    }

    public String getReporterTagCode() {
        return reporterTagCode;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setVacationNumber(String vacationNumber) {
        this.vacationNumber = vacationNumber;
    }

    public void setVacationApplicationDate(Date vacationApplicationDate) {
        this.vacationApplicationDate = vacationApplicationDate;
    }

    public void setVacationStartDate(Date vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public void setVacationEndDate(Date vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public void setVacationReason(String vacationReason) {
        this.vacationReason = vacationReason;
    }

    public void setVacationCode(String vacationCode) {
        this.vacationCode = vacationCode;
    }

    public void setAlldayCode(String alldayCode) {
        this.alldayCode = alldayCode;
    }

    public void setReporterTagCode(String reporterTagCode) {
        this.reporterTagCode = reporterTagCode;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public String toString() {
        return "ApplicationVacationDTO{" +
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
