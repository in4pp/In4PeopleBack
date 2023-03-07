package com.in4peopl.bootrestapi.member.entity;

import com.in4peopl.bootrestapi.deptandteam.entity.Department;
import com.in4peopl.bootrestapi.deptandteam.entity.Team;
import com.in4peopl.bootrestapi.position.entity.Position;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Entity
//@Table(name = "MEMBER")
public class Member {

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
    private String hourlyWage; //시급

    // FK
    private Department departmentCode; // 부서코드
    private Team teamCode; // 팀코드
    private Position positionCode; // 직급코드

    // 다 대 다 -> 일 대 다  + 일 대 다
    private List<MemAuthority> memAuthorityList; // 권한 목록
}






