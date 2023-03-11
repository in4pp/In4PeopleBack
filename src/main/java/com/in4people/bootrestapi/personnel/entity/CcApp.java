package com.in4people.bootrestapi.personnel.entity;

import com.in4people.bootrestapi.approval.entity.Approval;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CC_APP")
public class CcApp {

    // 경조비 신청
    // 결재


//    Approval class
//
//    docCode; // 103
//    memCode; // 로그인된 멤코드정보

//
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "DOC_CODE")
//    private CC_APP ccCode; // 경조비코드
//
//    ccCode.get(getDocCode);
//    ccCode.setCcCode(10);
//
//    1.
//    Approval 테이블에 insert
//    2.생성된 doccode뽑아서 + 선택된 경조비코드를 param으로 받아서 CC_APP에 insert




    @Id
    @Column(name = "DOC_CODE")
    private String docCode; // 문서번호

    @ManyToOne
    @JoinColumn(name = "CC_CODE")
    private CcExpense ccExpense; // 경조비코드, FK, NOT NULL

}
