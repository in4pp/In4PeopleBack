package com.in4people.bootrestapi.dailyWorker.entity;

import com.in4people.bootrestapi.salary.entity.EmployeeSalarySetting;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DAILY_WORKER")
@SequenceGenerator(    name = "DAILY_WORKER_SEQ_GENERATOR",
        sequenceName = "WORKER_CODE_SEQ",
        initialValue = 1, allocationSize = 1
)
public class DailyWorker {

    @Id
    @Column(name = "WORKER_CODE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_WORKER_SEQ_GENERATOR")
    private int workerCode;

    @Column(name = "WORKER_NAME")
    private String workerName;

    @Column(name = "WORKER_REG_NUMBER")
    private String workerRegNumber;

    @Column(name = "WORKER_PHONE")
    private String workerPhone;

    @Column(name = "WORKER_ADDRESS")
    private String workerAddress;

    @Column(name = "CREATED_AT")
    private Date createAt;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "SALARY_SETTING_CODE")
    private EmployeeSalarySetting employeeSalarySetting;

    @Override
    public String toString() {
        return "DailyWorker{" +
                "workerCode=" + workerCode +
                ", workerName='" + workerName + '\'' +
                ", workerRegNumber='" + workerRegNumber + '\'' +
                ", workerPhone='" + workerPhone + '\'' +
                ", workerAddress='" + workerAddress + '\'' +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
