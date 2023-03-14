package com.in4people.bootrestapi.personnel.entity;

import com.in4people.bootrestapi.deptandteam.entity.Department;
import com.in4people.bootrestapi.deptandteam.entity.Team;
import com.in4people.bootrestapi.member.entity.MemAuthority;
import com.in4people.bootrestapi.position.entity.Position;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PersonnelMember")
@Table(name = "MEMBER")
@ToString
public class PersonnelMember {

    @Id
    @Column(name = "MEM_CODE")
    private String memCode; //사원번호 PK
    @Column(name = "MEM_NAME")
    private String memName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "REGI_NUMBER")
    private String regiNumber;
    @Column(name = "GENDER")
    private char gender;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "MEM_PIC")
    private String memPic;
    @Column(name = "IS_MARRIED")
    private char isMarried;
    @Column(name = "IS_WORING")
    private char isWorking;  // 재직구분
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "HOURLY_WAGE")
    private String hourlyWage; //시급

    // FK
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_CODE")
    private Department department; // 부서코드
    @OneToOne
    @JoinColumn(name = "TEAM_CODE")
    private Team teamCode; // 팀코드
    @ManyToOne
    @JoinColumn(name = "POSITION_CODE")
    private Position position; // 직급코드



}