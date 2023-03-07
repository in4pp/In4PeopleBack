package com.in4people.bootrestapi.member.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemAuthorityDTO {

    private String memCode; // 사원번호 PK+FK

    private AuthorityDTO authNumber; // 시퀀스/경우의 수 14개
}
