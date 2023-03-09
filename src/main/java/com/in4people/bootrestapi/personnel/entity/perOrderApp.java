package com.in4people.bootrestapi.personnel.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PER_ORDER_APP")
@IdClass(AppPK.class)
public class perOrderApp {

    // 인사발령신청
    // 결재 FK, NOT NULL
    @Id
    @Column(name = "DOC_CODE")
    private String docCode; // 문서번호

    @Id
    @Column(name = "MEM_CODE")
    private String memCode; // 사원번호

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

    @ManyToOne
    @JoinColumn(name = "PER_CODE")
    private PerOrder perOrder; // 인사발령코드, FK, NOT NULL
}
