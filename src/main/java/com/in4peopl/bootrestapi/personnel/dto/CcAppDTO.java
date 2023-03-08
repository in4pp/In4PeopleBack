package com.in4peopl.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CcAppDTO {

    // 경조비 신청

//    private // 결재 FK

    private CcExpenseDTO ccCode; // 경조비코드, FK, NOT NULL

}
