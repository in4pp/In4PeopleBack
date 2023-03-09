package com.in4people.bootrestapi.approveWork.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 전자 결제 승인 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "APPROVED_CATEGORY")
public class ApprovedCategory {

    @Id
    @Column(name = "APPROVED__CODE" )
    private String approvedCode;  // 결제 상태 코드 PK

    @Column(name = "APPROVED__NAME")
    private String approvedName;// 결제 상태 이름
}
