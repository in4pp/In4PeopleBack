package com.in4people.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcAppDTO {

    // 경조비 신청

    private Long idNum; // 신청번호, PK, NOT NULl

    private String docCode; // 문서번호, NOT NULL

    private CcExpenseDTO ccCode; // 경조비코드, NOT NULL

}
