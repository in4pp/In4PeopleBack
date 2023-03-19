package com.in4people.bootrestapi.approval.dto;


import com.in4people.bootrestapi.deptandteam.dto.DepartmentDTO;
import com.in4people.bootrestapi.deptandteam.dto.TeamDTO;
import com.in4people.bootrestapi.member.dto.MemAuthorityDTO;
import com.in4people.bootrestapi.position.dto.PositionDTO;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApprovalMemDTO {

    private String memCode; //사원번호 PK
    private String memName;
//    private char isWorking;  // 재직구분
    // FK
    private DepartmentDTO departmentCode; // 부서코드
    private PositionDTO positionCode; // 직급코드

}
