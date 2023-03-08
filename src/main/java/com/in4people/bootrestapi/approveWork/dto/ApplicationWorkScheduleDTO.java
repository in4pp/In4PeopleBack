package com.in4people.bootrestapi.approveWork.dto;


import lombok.*;

import java.util.Date;

// 근무 스케줄 신청 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApplicationWorkScheduleDTO {

    private String scheduleNumber;         // 스케줄 번호 PK

    private String scheduleStartDate;      // 스케줄 적용 시작일

    private Date scheduleApplicationDate;  // 신청일자

    private String worktypeCode;           // 근무 유형 코드

    // FK
    private String workSettingNumber;      // 근무 설정 번호

    private String memCode;                // 사원 번호

    private String reporterTagCode;        // 상신자 태그 코드

    private String documentNumber;         // 전자 결제 번호
}
