package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAXATION")
public class Taxation {

    @Id
    @Column(name = "TAXATION_CODE")
    private String taxationCode;

    @Column(name = "TAXATION_NAME")
    private String taxationName;

    @Column(name = "TAX_RATE")
    private float taxRate;
}
