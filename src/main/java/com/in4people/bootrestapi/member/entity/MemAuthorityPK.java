package com.in4people.bootrestapi.member.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemAuthorityPK implements Serializable {

    private String memCode; // 사원번호 PK+FK

    private Authority authNumber; // 시퀀스/경우의 수 14개
}
