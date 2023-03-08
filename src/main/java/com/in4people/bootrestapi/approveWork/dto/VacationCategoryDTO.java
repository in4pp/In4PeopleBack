package com.in4people.bootrestapi.approveWork.dto;

import lombok.*;

// 휴가 종류 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VacationCategoryDTO {

    private String vacationCode;   // 휴가 코드 PK

    private String vacationName;   // 휴가 이름
}
