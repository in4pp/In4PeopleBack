package com.in4people.bootrestapi.personnel.entity;

import com.in4people.bootrestapi.personnel.dto.PerOrderDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

//@Entity
//@Table(name = "PER_ORDER_APP")
public class perOrderApp {

    // 인사발령신청

    // 결재 FK, NOT NULL

    @Column(name = "DATE_LEAVE")
    private Date dateLeave; // 휴직일자

    @Column(name = "DATE_REINSTATEMENT")
    private Date dateReinstatement; // 복직일자

    @Column(name = "RETIREMENT_DATE")
    private Date retirementDate; // 퇴직일자

    @Column(name = "APPLICATION_DEPARTMENT")
    private String applicationDepartment; // 신청부서

    @Column(name = "ORDER_DATE")
    private Date orderDate; // 발령일자

    @Column(name = "PER_REASON")
    private String perReason; // 사유

    @JoinColumn(name = "PER_CODE")
    private PerOrderDTO perOrderDTO; // 인사발령코드, FK, NOT NULL
}
