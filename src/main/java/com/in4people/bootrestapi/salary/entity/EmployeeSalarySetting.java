package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "EMPLOYEE_SALARY_SETTING")
public class EmployeeSalarySetting {

    @Id
    @Column(name = "SALARY_SETTING_CODE")
    private String salarySettingCode;
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK

    @Column(name = "BANK")
    private Date bank;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "SETTING_DATE")
    private Date settingDate;
}
