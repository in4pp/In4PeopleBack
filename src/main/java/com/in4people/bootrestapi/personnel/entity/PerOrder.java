package com.in4people.bootrestapi.personnel.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PER_ORDER")
public class PerOrder {

    // 인사발령

    @Id
    @Column(name = "PER_CODE")
    private String perCode; // 인사발령코드, PK, NOT NULL

    @Column(name = "PER_NAME")
    private String perName; // 인사발령명

}
