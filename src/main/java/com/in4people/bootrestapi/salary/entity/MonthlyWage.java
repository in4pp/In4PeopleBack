package com.in4people.bootrestapi.salary.entity;

import com.in4people.bootrestapi.common.StringPrefixSequenceGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MONTHLY_WAGE")
public class MonthlyWage {

    @Id
    @Column(name = "MONTHLY_WAGE_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MONTHLY_SEQ_CODE")
    @GenericGenerator(name = "MONTHLY_SEQ_CODE", strategy = "com.in4people.bootrestapi.common.StringPrefixSequenceGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "MON_")

            })
    private String monthlyWageCode;



//    // FK 사원 코드
//    @Column(name = "MEM_CODE")
//    private String memCode;


    @Column(name = "MONTHLY_PAYCHECK")
    private int monthlyPaycheck;

    @Column(name = "NET_SALARY")
    private int netSalary;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "BONUS_SUM")
    private int bonusSUM;

    @Column(name = "TOTAL_SUM")
    private int totalSum;

    @Column(name = "NATIONAL_PENSION")
    private int nationalPension;

    @Column(name = "HEALTH_INSURANCE")
    private int healthInsurance;

    @Column(name = "EMPLOYMENT_INSURANCE")
    private int employmentInsurance;

    @Column(name = "INCOME_TAX1")
    private int incomeTax1;

    @Column(name = "INCOME_TAX2")
    private int incomeTax2;

    // fk
    @Column(name = "SALARY_SETTING_CODE")
    private String salarySettingCode;







}
