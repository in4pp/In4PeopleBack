package com.in4peopl.bootrestapi.personnel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CERTIFICATE")
public class Certificate {

    // 증명서
    @Id
    @Column(name = "CER_CODE")
    private String cerCode; // 증명서코드, PK, NOT NULL

    @Column(name = "CER_NAME")
    private String cerName; // 증명서명

}
