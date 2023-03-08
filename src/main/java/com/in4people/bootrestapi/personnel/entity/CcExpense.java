package com.in4people.bootrestapi.personnel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CC_EXPENSE")
public class CcExpense {

    // 경조비
    @Id
    @Column(name = "CC_CODE")
    private String ccCode; // 경조비코드, PK, NOT NULL

    @Column(name = "CC_NAME")
    private String ccName; // 경조비명

    @Column(name = "CC_AMOUNT")
    private int ccAmount; // 경조비금액

}
