package com.in4peopl.bootrestapi.member.entity;

import com.in4peopl.bootrestapi.member.dto.AuthorityDTO;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemAuthorityPK implements Serializable {

    private String memCode; // 사원번호 PK+FK

    private AuthorityDTO authNumber; // 시퀀스/경우의 수 14개
}
