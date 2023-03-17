package com.in4people.bootrestapi.workState.dto;

// 근태관리 전용 MEMBER DTO

import com.in4people.bootrestapi.deptandteam.dto.DepartmentDTO;
import com.in4people.bootrestapi.deptandteam.dto.TeamDTO;
import com.in4people.bootrestapi.position.dto.PositionDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class WorkMemberDTO {

    private String memCode; //사원번호 PK
    private String memName;
    private String password;
    private String regiNumber;
    private char gender;
    private String phone;
    private String email;
    private String nationality;
    private String memPic;
    private char isMarried;
    private char isWorking;  // 재직구분
    private String address;


    // FK
    private DepartmentDTO departmentCode; // 부서코드
    private TeamDTO teamCode; // 팀코드
    private PositionDTO positionCode; // 직급코드
}
