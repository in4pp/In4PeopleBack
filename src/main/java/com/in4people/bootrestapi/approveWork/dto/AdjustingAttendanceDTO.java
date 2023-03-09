package com.in4people.bootrestapi.approveWork.dto;

import com.in4people.bootrestapi.schedule.dto.ApplicationWorkScheduleDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// 근태 조정 신청 DTO
public class AdjustingAttendanceDTO {

    private String adjustAttendNumber;   // 근태 조정 번호 PK

    private Date adjustApplicationDate;  // 신청일

    private String adjustScheduleDate;   // 스케줄 적용 조정일

    private String adjustStarttime;      // 조정 출근시간

    private String adjustEndtime;        // 조정 퇴근시간

    private String adjustReason;         // 조정 사유


    // FK
    private ApplicationWorkScheduleDTO scheduleNumber;       // 스케줄 번호

    private ReporterTagDTO reporterTagCode;      // 상신자 태그 코드

    private DocumentApprovalDTO documentNumber;       // 전자결제번호


}