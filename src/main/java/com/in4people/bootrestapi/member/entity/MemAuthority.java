package com.in4people.bootrestapi.member.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MEM_AUTHORITY")
@IdClass(MemAuthorityPK.class)
public class MemAuthority {

    @Id
    @Column(name = "MEM_CODE")
    private String memCode; // 사원번호 PK+FK

    @Id
    @ManyToOne
    @JoinColumn(name = "AUTH_NUMBER")
    private Authority authNumber; // 시퀀스/경우의 수 14개
}
