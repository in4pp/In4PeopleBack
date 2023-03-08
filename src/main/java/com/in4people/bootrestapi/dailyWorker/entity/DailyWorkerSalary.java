package com.in4people.bootrestapi.dailyWorker.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "DAILY_WORKER_SALARY")
@SequenceGenerator(    name = "DAILY_WORKER_SALARY_SEQ_GENERATOR",
        sequenceName = "SALARY_CODE_SEQ",
        initialValue = 1, allocationSize = 1
)
public class DailyWorkerSalary {

    @Id
    @Column(name = "SALARY_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_WORKER_SALARY_SEQ_GENERATOR")
    private int salaryCode;

    @Column(name = "TOTAL_PAYMENT")
    private int totalPayment;

    @Column(name = "AFTER_TAX_INCOME")
    private int afterTaxIncome;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;

    @Column(name = "PAY_COMPLETE_YN")
    private char payCompleteYn;

    @Column(name = "TAX")
    private int tax;

    @Column(name = "CREATED_AT")
    private Date createAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "WORKER_CODE")
    private DailyWorker dailyWorker;
}
