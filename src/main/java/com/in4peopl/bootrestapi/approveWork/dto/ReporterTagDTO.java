package com.in4peopl.bootrestapi.approveWork.dto;

import lombok.*;

// 상신자 태그 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReporterTagDTO {

    private String reporterTagCode;   // 상신자 태그 코드 FK

    private String memCode;           // 사원번호 PK
}
