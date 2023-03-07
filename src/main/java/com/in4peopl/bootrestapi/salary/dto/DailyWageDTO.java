package com.in4peopl.bootrestapi.salary.dto;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DailyWageDTO {

    private String dailyWageCode;                   // 일급코드
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK
    private Date workDate;                          // 근무일자            -- 수정해야함 근태 테이블에서 가져와야함!!
    private Date getToWork;                         // 출근시간            -- 수정해야함 근태 테이블에서 가져와야함!!
    private Date getOffWork;                        // 퇴근시간            -- 수정해야함 근태 테이블에서 가져와야함!!
    private Date overtimeStarttime;                 // 연장근무시작시간            -- 수정해야함 근태 테이블에서 가져와야함!!
    private Date overtimeEndtime;                   // 연장근무종료시간
    // 초과근무코드 OVERTIME_WORK_CODE overtimeWorkCode VARCHAR2(30) VARCHAR2(30) 근태에서 FK
    private float rewardMultiplier;                   // 보상배율
    private int dailySum;                             // 일급합계
}
