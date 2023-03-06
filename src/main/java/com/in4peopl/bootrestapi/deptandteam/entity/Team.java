package com.in4peopl.bootrestapi.deptandteam.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Team {

    private int teamCode;

    private String teamName; // 팀명
    
    private Department departmentCode; // 부서코드


}

