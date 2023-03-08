package com.in4people.bootrestapi.personnel.entity;

import com.in4people.bootrestapi.personnel.dto.CertificateDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

//@Entity
//@Table(name = "CERTIFICATE_APP")
public class CertificateApp {

    // 증명서 신청


//    private // 결재 FK

    @Column(name = "CER_REASON")
    private String cerReason; // 사유

    @JoinColumn(name = "CER_CODE")
    private CertificateDTO certificateDTO; // 증명서 코드, FK, NOT NULL

}
