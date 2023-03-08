package com.in4people.bootrestapi.approveWork.dto;


// 근무 설정 DTO
public class WorkSettingDTO {

    private String workSettingNumber;   // 근무 설정 번호 FK

    private String basicworkTime;       // 기본 근무 시간

    private String starttimeAvailwork;  // 출근 가능 시작 시간

    private String endtimeAvailwork;    // 퇴근 가능 시작 시간

    private String basicrestTime;       // 휴게 시간

    private int fixedWorkingHours;      // 주 소정 근로 시간

    private int maximumOvertimeHours;   // 주 최대 연장 근무 시간

    private int workdayRule;            // 근무 요일 규정

    private String worktypeCode;        // 근무 유형 코드 FK
}
