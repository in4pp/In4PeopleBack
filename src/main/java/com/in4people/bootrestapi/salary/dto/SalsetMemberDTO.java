package com.in4people.bootrestapi.salary.dto;

import com.in4people.bootrestapi.deptandteam.dto.DepartmentDTO;
import com.in4people.bootrestapi.deptandteam.dto.TeamDTO;
import com.in4people.bootrestapi.position.dto.PositionDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SalsetMemberDTO {

    private String memCode; //사원번호 PK
    private String memName;
    private char isWorking;  // 재직구분
    private String address;


    // FK
    private DepartmentDTO departmentCode; // 부서코드
    private TeamDTO teamCode; // 팀코드
    private PositionDTO positionCode; // 직급코드

    // 급여설정 리스트~~
    private List<EmployeeSalarySettingDTO> employeeSalarySettingList;

}
