package com.in4people.bootrestapi.vacation.entity;


import com.in4people.bootrestapi.workState.entity.WorkMember;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

// 연차 생성 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ANNUAL_MAKE")
public class AnnualMake {


    @Id
    @Column(name = "ANNUAL_MAKE_NUMER")
    private String annualMakeNumber;  // 연차생성번호 PK

    @Column(name = "STANDARD_YEAR")
    private int standardYear;  // 기준년도

    @Column(name = "ANNUAL_MAKE_DATE")
    private Date annualMakeDate;   // 연차생성일

    @Column(name = "ANNUAL_DAY")
    private int annualDay;   // 발생연차

    @Column(name = "MONTHLY_LEAVE")
    private int monthlyLeave;  // 1년 미만 월 발생분

    @Column(name = "LASTYEAR _ANNUAL")
    private int lastyearAnnual;  // 전년도 잔여 연차

    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private WorkMember memCode;   // 연차생성번호 FK


}