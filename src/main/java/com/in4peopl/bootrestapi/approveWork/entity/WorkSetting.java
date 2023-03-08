package com.in4peopl.bootrestapi.approveWork.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 근무 설정 entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "WORK_SETTING")
public class WorkSetting {


    @Id
    @Column(name = "WORK_SETTING_NUMBER")
    private String workSettingNumber;   // 근무 설정 번호 FK

    @Column(name = "BASICWORK_TIME")
    private String basicworkTime;       // 기본 근무 시간

    @Column(name = "STARTTIME_AVAILWORK")
    private String starttimeAvailwork;  // 출근 가능 시작 시간

    @Column(name = "ENDTIME_AVAILWORK")
    private String endtimeAvailwork;    // 퇴근 가능 시작 시간

    @Column(name = "BASICREST_TIME")
    private String basicrestTime;       // 휴게 시간

    @Column(name = "FIXED_WORKING_HOURS")
    private int fixedWorkingHours;      // 주 소정 근로 시간

    @Column(name = "MAXIMUM_OVERTIME_HOURS")
    private int maximumOvertimeHours;   // 주 최대 연장 근무 시간

    @Column(name = "WORKDAY_RULE")
    private int workdayRule;            // 근무 요일 규정

    @Column(name = "WORKTYPE_CODE")
    private String worktypeCode;        // 근무 유형 코드 FK

}
