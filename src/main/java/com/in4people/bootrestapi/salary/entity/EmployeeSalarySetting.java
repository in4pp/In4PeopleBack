package com.in4people.bootrestapi.salary.entity;

import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE_SALARY_SETTING")
public class EmployeeSalarySetting {

    @Id
    @Column(name = "SALARY_SETTING_CODE")
    private String salarySettingCode;
    // 사원번호 MEM_CODE memCode VARCHAR2(100) 사원테이블에서~ FK

    @Column(name = "BANK")
    private String bank;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "SETTING_DATE")
    private Date settingDate;

    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private Member member;

    @Override
    public String toString() {
        return "EmployeeSalarySetting{" +
                "salarySettingCode='" + salarySettingCode + '\'' +
                ", bank='" + bank + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", settingDate=" + settingDate +
                '}';
    }
}
