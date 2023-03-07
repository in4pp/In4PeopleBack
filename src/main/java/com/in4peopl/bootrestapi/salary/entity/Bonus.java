package com.in4peopl.bootrestapi.salary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAX_FREE")
public class Bonus {

    @Id
    @Column(name = "BONUS_CODE")
    private String bonusCode;

    @Column(name = "BONUS_NAME")
    private String bonusName;
}
