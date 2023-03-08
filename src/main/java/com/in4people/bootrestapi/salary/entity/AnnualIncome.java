package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "TAX_FREE")
public class AnnualIncome {

    @Id
    @Column(name = "ANNUAL_SALARY_CODE")
    private String annualSalaryCode;

    @Column(name = "PAYMENT_YEAR")
    private Date paymentYear;

    @Column(name = "ANNUAL_SALARY")
    private int annualSalary;

    @Column(name = "REAL_SALARY")
    private int realSalary;
}
