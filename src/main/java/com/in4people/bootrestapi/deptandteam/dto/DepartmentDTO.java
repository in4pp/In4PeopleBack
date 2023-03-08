package com.in4people.bootrestapi.deptandteam.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DepartmentDTO {

    private String departmentCode; // 부서코드 PK
    private String departmentName; // 부서명
}
