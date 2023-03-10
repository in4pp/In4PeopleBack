package com.in4people.bootrestapi.approval.entity;

import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "APPROVAL")
public class Approval {

    @Id
    @Column(name = "DOC_CODE")
    private String docCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEM_CODE")
    private Member memCode; // memCode FK 상신인

    @Column(name = "DOC_TYPE")
    private String docType;  // 결재종류(ex:업무, 근태)

    @Column(name = "IS_APPROVED")
    private char isApproved; // W/Y/N

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_CODE")
    private List<Approver> approverList; // 결재자 리스트

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_CODE")
    private List<Referee> refereeList; // 참조인 리스트

    @Column(name ="TITLE")
    private String title; //제목

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_CODE")
    private Bookmark bookmark; //
    // doc을 들고오고, JOIN BOOKMARK에 where BOOKMARK.memCode를 자신을 준다.

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOC_CODE")
    private List<DocAttachment> docAttachmentList; // 결재_첨부파일


    /*
    상신함 - memCode = 나
    참조된함 - WHERE REFFEREE.memCode = 나
    결재함 - WHERE APPROVER.memCode = 나
    * */
}