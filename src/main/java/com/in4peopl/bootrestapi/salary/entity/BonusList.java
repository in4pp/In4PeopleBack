package com.in4peopl.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "BONUS_LIST")
public class BonusList {

    @Id
    @Column(name = "AWARD_CODE")
    private String awardCode;

    @Column(name = "BONUS_AMOUNT")
    private int bonusAmount;

    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;
}
