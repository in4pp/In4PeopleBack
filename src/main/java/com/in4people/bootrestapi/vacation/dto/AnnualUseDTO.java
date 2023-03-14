package com.in4people.bootrestapi.vacation.dto;

import com.in4people.bootrestapi.approveWork.dto.ApplicationVacationDTO;
import lombok.*;

// 연차 사용 이력 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnnualUseDTO {

    private String annualUseNumber;    // 연차 사용 이력 번호 PK

    private int  annualUseDay;         // 사용 연차

    private int remainAnnual;          // 남은 연차


    // FK
    private AnnualMakeDTO annualMakeNumber;    // 연차 생성 번호

    private ApplicationVacationDTO vacationNumber;      // 휴가 신청 번호
}
