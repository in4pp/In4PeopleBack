package com.in4people.bootrestapi.salary.entity;

import com.in4people.bootrestapi.deptandteam.entity.Department;
import com.in4people.bootrestapi.deptandteam.entity.Team;
import com.in4people.bootrestapi.position.entity.Position;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MEMBER")
public class SalsetMember {


    @Id
    @Column(name = "MEM_CODE")
    private String memCode; //사원번호 PK
    @Column(name = "MEM_NAME")
    private String memName;

    @Column(name = "IS_WORING")
    private char isWorking;  // 재직구분
    @Column(name = "ADDRESS")
    private String address;

    // FK
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_CODE")
    private Department departmentCode; // 부서코드
    @OneToOne
    @JoinColumn(name = "TEAM_CODE")
    private Team teamCode; // 팀코드
    @ManyToOne
    @JoinColumn(name = "POSITION_CODE")
    private Position positionCode; // 직급코드

    @OneToMany
    @JoinColumn(name = "MEM_CODE")
    private List<EmployeeSalarySetting> employeeSalarySettingList;




}

