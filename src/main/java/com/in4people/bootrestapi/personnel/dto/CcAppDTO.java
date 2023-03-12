package com.in4people.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcAppDTO {

    // 경조비 신청

//    private String docCode; // 문서번호

    private CcExpenseDTO ccCode; // 경조비코드, FK, NOT NULL

}
