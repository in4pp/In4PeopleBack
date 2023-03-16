package com.in4people.bootrestapi.personnel.entity;

import com.in4people.bootrestapi.approval.entity.Approval;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PER_ORDER_APP")
@SequenceGenerator(
        name = "PERAPP_SEQ_GENERATOR",
        sequenceName = "SEQ_PERAPP_CODE",
        initialValue = 1, allocationSize = 1
)
public class PerOrderApp {

    // 인사발령신청
    // 결재 NOT NULL

    @Id
    @Column(name = "ID_NUM")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PERAPP_SEQ_GENERATOR"
    )
    private Long idNum; // 신청번호

    @Column (name = "DOC_CODE")
    private String docCode; // 문서번호

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

    @Column(name = "ORDER_DETAILS")
    private String orderDetails; // 발령내용

    @ManyToOne
    @JoinColumn(name = "PER_CODE")
    private PerOrder perOrder; // 인사발령코드, FK, NOT NULL
}
