package com.in4people.bootrestapi.schedule.dto;



import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// 근무 설정 DTO
public class WorkSettingUpDTO {


    private String workSettingNumber;   // 근무 설정 번호 PK


    private String basicworkTime;       // 기본 근무 시간

    private String basicworkTime1;      // 기본 근무 시작 시간

    private String basicworkTime2;      // 기본 근무 종료 시간

    private String starttimeAvailwork;  // 출근 가능 시작 시간

    private String starttimeAvailwork1;  // 출근 가능 시작 시간
    private String starttimeAvailwork2;  // 출근 가능 시작 시간


    private String endtimeAvailwork;    // 퇴근 가능 시작 시간

    private String endtimeAvailwork1;    // 퇴근 가능 시작 시간
    private String endtimeAvailwork2;    // 퇴근 가능 시작 시간


    private String basicrestTime;       // 휴게 시간

    private String basicrestTime1;      // 휴게 시작 시간

    private String basicrestTime2;      // 휴게 종료 시간


    private int fixedWorkingHours;      // 주 소정 근로 시간


    private int maximumOvertimeHours;   // 주 최대 연장 근무 시간


    private int workdayRule;            // 근무 요일 규정

    private int day1;            // 월
    private int day2;            // 화
    private int day3;            // 수
    private int day4;            // 목
    private int day5;            // 금
    private int day6;            // 토
    private int day7;            // 일

    private String worktypeCode;        // 근무 유형 코드 FK
}
