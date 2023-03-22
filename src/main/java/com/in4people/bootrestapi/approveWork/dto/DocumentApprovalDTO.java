package com.in4people.bootrestapi.approveWork.dto;

import com.in4people.bootrestapi.schedule.dto.ApplicationWorkScheduleDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

// 전자 결제 이력 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DocumentApprovalDTO {

    private String documentNumber;          //전자 결제 번호 PK

    private Date approvedDate;              // 승인 날짜

    private String reasonsRejection;        // 사유


    // FK
    private ApprovedCategoryDTO approvedCode;            // 결제 상태 코드

    private ApplicationVacationDTO vacationNumber;          // 휴가 신청 번호

    private ApplicationOvertimeWorkDTO overtimeNumber;          // 연장 근무 번호

    private AdjustingAttendanceDTO adjustAttendNumber;      // 근태 조정 번호

    private ApplicationWorkScheduleDTO scheduleNumber;          // 스케줄 번호


    // 양방향

//    List<ApplicationWorkScheduleDTO> applicationWorkScheduleList; // 스케줄목록
}
