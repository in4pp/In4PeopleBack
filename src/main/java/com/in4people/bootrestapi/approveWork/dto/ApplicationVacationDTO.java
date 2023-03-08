package com.in4people.bootrestapi.approveWork.dto;



import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// 휴가 신청 DTO (양방향)
public class ApplicationVacationDTO {

    private String vacationNumber;          // 휴가 신청 번호 PK

    private Date vacationApplicationDate;   // 신청일

    private Date vacationStartDate;         // 휴가 시작 기간

    private Date vacationEndDate;           // 휴가 종료 기간

    private String vacationReason;          // 휴가 사유

    // FK
    private VacationCategoryDTO vacationCode;            // 휴가 코드

    private AlldayCategoryDTO alldayCode;              // 전일/반일 코드

    private ReporterTagDTO reporterTagCode;         // 상신자 태그 코드

    private DocumentApprovalDTO documentNumber;          // 전자 결제 번호

}
