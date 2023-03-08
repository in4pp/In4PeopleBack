package com.in4people.bootrestapi.salary.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "INCOME_TAX")
public class IncomeTax {

    @Id
    @Column(name = "INCOME_TAX_CODE")
    private String incomeTaxCode;

    @Column(name = "LOWER_TAX_BASE_LIMIT")
    private long lowerTaxBaseLimit;

    @Column(name = "UPPER_TAX_BASE_LIMIT")
    private long upperTaxBaseLimit;

    @Column(name = "TAX_RATE")
    private double taxRate;

    @Column(name = "DEDUCTION_AMOUNT")
    private long deductionAmount;



}
