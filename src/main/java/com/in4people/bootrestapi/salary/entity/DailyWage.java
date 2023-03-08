package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "DAILY_ WAGE")
public class DailyWage {

    @Id
    @Column(name = "DAILY _WAGE_CODE")
    private String dailyWageCode;
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK

    @Column(name = "WORK_DATE")
    private Date workDate;

    @Column(name = "GET_TO_WORK")
    private Date getToWork;

    @Column(name = "GET_OFF_WORK")
    private Date getOffWork;

    @Column(name = "OVERTIME_STARTTIME")
    private Date overtimeStarttime;

    @Column(name = "OVERTIME_ENDTIME")
    private Date overtimeEndtime;
    // 초과근무코드 OVERTIME_WORK_CODE overtimeWorkCode VARCHAR2(30) VARCHAR2(30) 근태에서 FK

    @Column(name = "REWARD_MULTIPLIER")
    private float rewardMultiplier;

    @Column(name = "DAILY_SUM")
    private int dailySum;


}
