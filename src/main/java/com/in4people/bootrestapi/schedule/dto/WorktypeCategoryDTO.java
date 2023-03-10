package com.in4people.bootrestapi.schedule.dto;

import lombok.*;

// 근무 유형 카테고리 DTO
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class WorktypeCategoryDTO {

    private String worktypeCode;   // 근무 유형 코드  PK

    private String worktypeName; // 근무 유형 이름
}
