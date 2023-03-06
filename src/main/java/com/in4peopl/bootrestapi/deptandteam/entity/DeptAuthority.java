package com.in4peopl.bootrestapi.deptandteam.entity;

import com.in4peopl.bootrestapi.member.entity.Authority;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptAuthority {

    private int authNumber; // 시퀀스 / 경우의 수 14개

    private Department departmentCode;  // 부서코드

    private Authority authName; // 권한명
}
