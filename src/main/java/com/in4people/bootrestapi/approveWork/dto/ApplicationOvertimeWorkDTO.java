package com.in4people.bootrestapi.approveWork.dto;


import com.in4people.bootrestapi.schedule.dto.WorkSettingDTO;
import com.in4people.bootrestapi.workState.dto.WorkMemberDTO;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
// 연장 근무 신청 DTO (양방향)
public class ApplicationOvertimeWorkDTO {

    private String overtimeNumber;           // 연장 근무 번호 PK

    private Date overtimeApplicationDate;    // 신청일

    private String overtimeScheduleDate;     // 연장 근무 적용일 + 시간


    //FK
    private WorkMemberDTO memCode;                  // 사원번호

    private ReporterTagDTO reporterTagCode;          // 상신자 태그 코드

    private WorkSettingDTO workSettingNumber;        // 근무 설정 번호

    private DocumentApprovalDTO documentNumber;           // 전자 결제 번호


}
