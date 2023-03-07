package com.in4peopl.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "MONTHLY_WAGE")
public class MontlyWage {

    @Id
    @Column(name = "MONTHLY_WAGE_CODE")
    private String monthlyWageCode;

    @Column(name = "MONTHLY_PAYCHECK")
    private String monthlyPaycheck;

    @Column(name = "NET_SALARY")
    private int netSalary;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "BONUS_SUM")
    private int bonusSUM;
}
