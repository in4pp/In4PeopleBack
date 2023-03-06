package com.in4peopl.bootrestapi.deptandteam.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {

    private String departmentCode; // 부서코드 PK
    private String departmentName; // 부서명
}
