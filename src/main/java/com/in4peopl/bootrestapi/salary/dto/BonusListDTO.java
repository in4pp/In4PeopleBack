package com.in4peopl.bootrestapi.salary.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BonusListDTO {

    private String awardCode;                   // 수여코드

    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK
    // 수당코드 BONUS_CODE bonusCode VARCHAR2(30) 과세테이블에서~ FK

    private int bonusAmount;                   // 수당금액
    private Date paymentDate;                  // 지급일

    // 과세코드 TAXATION_CODE taxationCode VARCHAR2(30) 과세테이블에서~ FK
    // 비과세코드 TAX_FREE_CODE taxFreeCode VARCHAR2(30) 비과세테이블에서~ FK


}
