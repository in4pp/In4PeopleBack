package com.in4people.bootrestapi.personnel.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CERTIFICATE_APP")
@IdClass(AppPK.class)
public class CertificateApp {

    // 증명서 신청
    // 결재 FK
    @Id
    @Column(name = "DOC_CODE")
    private String docCode; // 문서번호

    @Id
    @Column(name = "MEM_CODE")
    private String memCode; // 사원번호

    @Column(name = "CER_REASON")
    private String cerReason; // 사유

    @ManyToOne
    @JoinColumn(name = "CER_CODE")
    private Certificate certificate; // 증명서 코드, FK, NOT NULL

}
