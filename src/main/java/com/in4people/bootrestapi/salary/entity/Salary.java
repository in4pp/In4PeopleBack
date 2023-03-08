package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALARY")
public class Salary {

    @Id
    @Column(name = "SALARY_CODE")
    private String salaryCode;

    @Column(name = "SALARY_NAME")
    private String salaryName;
}
