package com.in4people.bootrestapi.approveWork.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 상신자 태그 entity
@Entity
@Table(name = "REPORTER_TAG")
public class ReporterTag {

    @Id
    @Column(name = "REPORTER_TAG_CODE")
    private String reporterTagCode;   // 상신자 태그 코드 FK

    @Column(name = "MEM_CODE")
    private String memCode;           // 사원번호 PK

    public ReporterTag() {
    }

    public ReporterTag(String reporterTagCode, String memCode) {
        this.reporterTagCode = reporterTagCode;
        this.memCode = memCode;
    }

    public String getReporterTagCode() {
        return reporterTagCode;
    }

    public void setReporterTagCode(String reporterTagCode) {
        this.reporterTagCode = reporterTagCode;
    }

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    @Override
    public String toString() {
        return "ReporterTag{" +
                "reporterTagCode='" + reporterTagCode + '\'' +
                ", memCode='" + memCode + '\'' +
                '}';
    }
}
