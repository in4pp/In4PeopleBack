package com.in4people.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAX_FREE")
public class TaxFree {

    @Id
    @Column(name = "TAX_FREE_CODE")
    private String taxFreeCode;

    @Column(name = "TAX_FREE_NAME")
    private String taxFreeName;

    @Column(name = "EXPLANATION")
    private float explanation;
}
