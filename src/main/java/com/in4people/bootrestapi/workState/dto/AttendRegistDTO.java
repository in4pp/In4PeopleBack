package com.in4people.bootrestapi.workState.dto;


import lombok.*;

import java.util.Date;

// 근태 등록 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AttendRegistDTO {

    private String attendRegistNumber;    // 근태번호 PK

    private Date workDate;      // 근무일자

    private Date getToWork;      // 출근시간

    private Date getOffWork;      // 퇴근시간


    // FK
    private WorkMemberDTO memCode;    // 사원번호

    private WorkStateDTO workStateCode;  // 근태 상태 코드

}
