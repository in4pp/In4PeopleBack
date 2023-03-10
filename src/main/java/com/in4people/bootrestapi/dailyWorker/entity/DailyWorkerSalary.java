package com.in4people.bootrestapi.dailyWorker.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "WORKER_CODE", insertable = false, updatable = false)
    private DailyWorker dailyWorker;

    @Override
    public String toString() {
        return "DailyWorkerSalary{" +
                "salaryCode=" + salaryCode +
                ", totalPayment=" + totalPayment +
                ", afterTaxIncome=" + afterTaxIncome +
                ", paymentDate=" + paymentDate +
                ", payCompleteYn=" + payCompleteYn +
                ", tax=" + tax +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
