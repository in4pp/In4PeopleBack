package com.in4people.bootrestapi.schedule.dto;

import com.in4people.bootrestapi.schedule.dto.ApplicationWorkScheduleDTO;
import lombok.*;

import java.util.Date;

// 근무 스케줄 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkScheduleDTO {

    private Date workDate;           // 근무 날짜 PK

    private ApplicationWorkScheduleDTO scheduleNumber;   // 스케줄 번호 FK

    private String workStarttime;    // 근무 시작 시간

    private String workEndtime;      // 근무 종료 시간

    private String restStarttime;    // 휴게 시작 시간

    private String restEndtime;      // 휴게 종료 시간

}
