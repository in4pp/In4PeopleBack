package com.in4people.bootrestapi.vacation.dto;

import com.in4people.bootrestapi.member.dto.MemberDTO;
import lombok.*;

import java.util.Date;

// 연차 생성 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnnualMakeDTO {

    private String annualMakeNumber;  // 연차생성번호 PK

    private int standardYear;  // 기준년도

    private Date annualMakeDate;   // 연차생성일

    private int annualDay;   // 발생연차

    private int monthlyLeave;  // 1년 미만 월 발생분

    private int lastyearAnnual;  // 전년도 잔여 연차

    private MemberDTO memCode;   // 연차생성번호 FK

}
