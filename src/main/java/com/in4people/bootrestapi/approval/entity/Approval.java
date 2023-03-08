package com.in4people.bootrestapi.approval.entity;


import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "APPROVAL")
@IdClass(ApprovalPK.class)
public class Approval {

    @Id
    @Column(name = "DOC_CODE")
    private String docCode;

    @Id
    @OneToOne
    @JoinColumn(name = "MEM_CODE")
    private Member memCode; //FK+PK 상신인

    @Column(name = "DOC_TYPE")
    private String docType;  // 결재종류(ex:업무, 근태)

    @Column(name = "IS_APPROVED")
    private char isApproved; // W/Y/N

//    @OneToMany
//    @JoinColumn(name = "DOC_CODE")
//    private List<Approver> approverList; // 결재자 리스트
//    @OneToMany
//    @JoinColumn(name = "DOC_CODE")
//    private List<Referee> refereeList; // 참조인 리스트
}
