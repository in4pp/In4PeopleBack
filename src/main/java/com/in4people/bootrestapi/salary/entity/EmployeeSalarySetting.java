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

    //JoinColumn 매핑설정
    //JoinColumn 내가 사용할 클래스타입이랑 연결해주겠다
    //String


    @Column(name = "MEM_CODE")
    private String memCode;



    @Column(name = "BANK")
    private String bank;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "SETTING_DATE")
    private Date settingDate;

    @Column(name = "BASIC_MONTHLY_SALARY")
    private Date basicMonthlySalary;

    @Column(name = "HOURLY_WAGE")
    private Date hourlyWage;




}
