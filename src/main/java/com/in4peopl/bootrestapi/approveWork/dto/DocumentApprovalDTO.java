package com.in4peopl.bootrestapi.approveWork.dto;

import java.util.Date;

// 전자 결제 이력 DTO (양방향)
public class DocumentApprovalDTO {

    private String documentNumber;          //전자 결제 번호 PK

    private Date approvedDate;              // 승인 날짜

    private String reasonsRejection;        // 사유


    // FK
    private String approvedCode;            // 결제 상태 코드

    private String vacationNumber;          // 휴가 신청 번호

    private String overtimeNumber;          // 연장 근무 번호

    private String adjustAttendNumber;      // 근태 조정 번호

    private String scheduleNumber;          // 스케줄 번호

    public DocumentApprovalDTO() {
    }

    public DocumentApprovalDTO(String documentNumber, Date approvedDate, String reasonsRejection, String approvedCode, String vacationNumber, String overtimeNumber, String adjustAttendNumber, String scheduleNumber) {
        this.documentNumber = documentNumber;
        this.approvedDate = approvedDate;
        this.reasonsRejection = reasonsRejection;
        this.approvedCode = approvedCode;
        this.vacationNumber = vacationNumber;
        this.overtimeNumber = overtimeNumber;
        this.adjustAttendNumber = adjustAttendNumber;
        this.scheduleNumber = scheduleNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public String getReasonsRejection() {
        return reasonsRejection;
    }

    public String getApprovedCode() {
        return approvedCode;
    }

    public String getVacationNumber() {
        return vacationNumber;
    }

    public String getOvertimeNumber() {
        return overtimeNumber;
    }

    public String getAdjustAttendNumber() {
        return adjustAttendNumber;
    }

    public String getScheduleNumber() {
        return scheduleNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public void setReasonsRejection(String reasonsRejection) {
        this.reasonsRejection = reasonsRejection;
    }

    public void setApprovedCode(String approvedCode) {
        this.approvedCode = approvedCode;
    }

    public void setVacationNumber(String vacationNumber) {
        this.vacationNumber = vacationNumber;
    }

    public void setOvertimeNumber(String overtimeNumber) {
        this.overtimeNumber = overtimeNumber;
    }

    public void setAdjustAttendNumber(String adjustAttendNumber) {
        this.adjustAttendNumber = adjustAttendNumber;
    }

    public void setScheduleNumber(String scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    @Override
    public String toString() {
        return "DocumentApprovalDTO{" +
                "documentNumber='" + documentNumber + '\'' +
                ", approvedDate=" + approvedDate +
                ", reasonsRejection='" + reasonsRejection + '\'' +
                ", approvedCode='" + approvedCode + '\'' +
                ", vacationNumber='" + vacationNumber + '\'' +
                ", overtimeNumber='" + overtimeNumber + '\'' +
                ", adjustAttendNumber='" + adjustAttendNumber + '\'' +
                ", scheduleNumber='" + scheduleNumber + '\'' +
                '}';
    }
}
