package com.in4people.bootrestapi.salary.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BonusDTO {


    private String bonusCode;                   // 수당코드
    private String bonusName;                   // 수당명
    // 과세코드 TAXATION_CODE taxationCode VARCHAR2(30) 과세테이블에서~ FK
    // 비과세코드 TAX_FREE_CODE taxFreeCode VARCHAR2(30) 과세테이블에서~ FK


}
