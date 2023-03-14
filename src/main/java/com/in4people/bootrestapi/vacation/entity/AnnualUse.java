package com.in4people.bootrestapi.vacation.entity;


import com.in4people.bootrestapi.approveWork.entity.ApplicationVacation;

import lombok.*;

import javax.persistence.*;

// 연차 사용 이력 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ANNUAL_USE")
public class AnnualUse {


    @Id
    @Column(name = "ANNUAL_USE_NUMBER")
    private String annualUseNumber;    // 연차 사용 이력 번호 PK

    @Column(name = "ANNUAL_USE_DAY")
    private int  annualUseDay;         // 사용 연차

    @Column(name = "REMAIN_ANNUAL")
    private int remainAnnual;          // 남은 연차


    // FK
    @ManyToOne
    @JoinColumn(name = "ANNUAL_MAKE_NUMER")
    private AnnualMake annualMakeNumber;    // 연차 생성 번호

    @ManyToOne
    @JoinColumn(name = "VACATION_NUBER")
    private ApplicationVacation vacationNumber;      // 휴가 신청 번호
}
