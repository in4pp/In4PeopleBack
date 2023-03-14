package com.in4people.bootrestapi.workState.dto;

import lombok.*;

// 근태 상태 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkStateDTO {

    private String workStateCode;  // 근태 상태 코드 PK

    private String workStateName;  // 근태 상태 이름
}
