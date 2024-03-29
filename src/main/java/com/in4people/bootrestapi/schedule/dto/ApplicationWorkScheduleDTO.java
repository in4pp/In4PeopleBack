package com.in4people.bootrestapi.schedule.dto;


import com.in4people.bootrestapi.approveWork.dto.DocumentApprovalDTO;
import com.in4people.bootrestapi.approveWork.dto.ReporterTagDTO;
import com.in4people.bootrestapi.workState.dto.WorkMemberDTO;
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



    // FK
    private WorkSettingDTO workSettingNumber;      // 근무 설정 번호

    private WorkMemberDTO memCode;                // 사원 번호

    private ReporterTagDTO reporterTagCode;        // 상신자 태그 코드

    private DocumentApprovalDTO documentNumber;         // 전자 결제 번호


}
