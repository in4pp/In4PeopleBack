package com.in4people.bootrestapi.personnel.dto;


import com.in4people.bootrestapi.deptandteam.dto.DepartmentDTO;
import com.in4people.bootrestapi.deptandteam.dto.TeamDTO;
import com.in4people.bootrestapi.position.dto.PositionDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonnelMemberSelectDTO {

    // 부서명 직급명 필요할 때
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

