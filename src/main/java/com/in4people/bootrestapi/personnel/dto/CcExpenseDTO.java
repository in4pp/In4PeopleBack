package com.in4people.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcExpenseDTO {

    // 경조비
    private String ccCode; // 경조비코드, PK, NOT NULL

    private String ccName; // 경조비명

    private int ccAmount; // 경조비금액

}
