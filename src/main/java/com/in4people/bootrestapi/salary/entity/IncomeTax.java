package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INCOME_TAX")
public class IncomeTax {

    @Id
    @Column(name = "INCOME_TAX_CODE")
    private String incomeTaxCode;

    @Column(name = "LOWER_TAX_BASE_LIMIT")
    private int lowerTaxBaseLimit;

    @Column(name = "UPPER_TAX_BASE_LIMIT")
    private int upperTaxBaseLimit;

    @Column(name = "TAX_RATE")
    private float taxRate;

    @Column(name = "DEDUCTION_AMOUNT")
    private int deductionAmount;


    public IncomeTax() {
    }

    public IncomeTax(String incomeTaxCode, int lowerTaxBaseLimit, int upperTaxBaseLimit, float taxRate, int deductionAmount) {
        this.incomeTaxCode = incomeTaxCode;
        this.lowerTaxBaseLimit = lowerTaxBaseLimit;
        this.upperTaxBaseLimit = upperTaxBaseLimit;
        this.taxRate = taxRate;
        this.deductionAmount = deductionAmount;
    }

    public String getIncomeTaxCode() {
        return incomeTaxCode;
    }

    public int getLowerTaxBaseLimit() {
        return lowerTaxBaseLimit;
    }

    public int getUpperTaxBaseLimit() {
        return upperTaxBaseLimit;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public int getDeductionAmount() {
        return deductionAmount;
    }

    public void setIncomeTaxCode(String incomeTaxCode) {
        this.incomeTaxCode = incomeTaxCode;
    }

    public void setLowerTaxBaseLimit(int lowerTaxBaseLimit) {
        this.lowerTaxBaseLimit = lowerTaxBaseLimit;
    }

    public void setUpperTaxBaseLimit(int upperTaxBaseLimit) {
        this.upperTaxBaseLimit = upperTaxBaseLimit;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public void setDeductionAmount(int deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    @Override
    public String toString() {
        return "IncomeTax{" +
                "incomeTaxCode='" + incomeTaxCode + '\'' +
                ", lowerTaxBaseLimit=" + lowerTaxBaseLimit +
                ", upperTaxBaseLimit=" + upperTaxBaseLimit +
                ", taxRate=" + taxRate +
                ", deductionAmount=" + deductionAmount +
                '}';
    }
}
