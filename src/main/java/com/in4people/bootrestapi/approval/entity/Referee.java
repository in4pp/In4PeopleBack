package com.in4people.bootrestapi.approval.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="REFEREE")
@IdClass(ApprovalPK.class)
public class Referee {

    @Id
    @Column(name ="DOC_CODE")
    private String docCode;

    @Id
    @Column(name ="MEM_CODE")
    private String memCode; // 북마크한 사람(로그인한사람의 memCode)

}


