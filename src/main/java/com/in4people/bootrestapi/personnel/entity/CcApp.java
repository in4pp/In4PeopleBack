package com.in4people.bootrestapi.personnel.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CC_APP")
@IdClass(AppPK.class)
public class CcApp {

    // 경조비 신청
    // 결재 FK
    @Id
    @Column(name = "DOC_CODE")
    private String docCode; // 문서번호

    @Id
    @Column(name = "MEM_CODE")
    private String memCode; // 사원번호

    @ManyToOne
    @JoinColumn(name = "CC_CODE")
    private CcExpense ccExpense; // 경조비코드, FK, NOT NULL

}
