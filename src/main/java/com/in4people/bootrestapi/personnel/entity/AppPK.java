package com.in4people.bootrestapi.personnel.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppPK implements Serializable {

    // 결재
    private String docCode; // 문서번호

    private String memCode; // 사원번호
}
