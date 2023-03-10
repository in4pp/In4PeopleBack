package com.in4people.bootrestapi.approveWork.dto;


import com.in4people.bootrestapi.workState.dto.WorkMemberDTO;
import lombok.*;

// 상신자 태그 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReporterTagDTO {

    private String reporterTagCode;   // 상신자 태그 코드 FK

    private WorkMemberDTO memCode;           // 사원번호 PK
}
