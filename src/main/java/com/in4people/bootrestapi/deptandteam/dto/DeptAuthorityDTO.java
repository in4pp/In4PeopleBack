package com.in4people.bootrestapi.deptandteam.dto;

import com.in4people.bootrestapi.member.dto.AuthorityDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeptAuthorityDTO {

    private int authNumber; // 시퀀스 / 경우의 수 14개

    private DepartmentDTO departmentCode; // 부서 코드
    
    private AuthorityDTO authName; //권한명
}
