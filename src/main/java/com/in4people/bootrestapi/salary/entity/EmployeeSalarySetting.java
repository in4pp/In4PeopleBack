package com.in4people.bootrestapi.salary.entity;

import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "EMPLOYEE_SALARY_SETTING")
public class EmployeeSalarySetting {

    @Id
    @Column(name = "SALARY_SETTING_CODE")
    private String salarySettingCode;

    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK
    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private Member memCode;


    @Column(name = "BANK")
    private String bank;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "SETTING_DATE")
    private Date settingDate;


}
