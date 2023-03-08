package com.in4people.bootrestapi.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_INFO")
@SequenceGenerator(
        name = "ORDER_SEQ_GENERATOR",
        sequenceName = "SEQ_ORDER_CODE",
        initialValue = 1, allocationSize = 1
)
public class OrderInfo {

    // 발령정보
    @Id
    @Column(name = "ORDER_NUMBER")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ORDER_SEQ_GENERATOR"
    )
    private int orderNumber; // PK, NOT NULL, 발령번호

    @Column(name = "ORDER_DETAILS")
    private String orderDetails; // 발령내용

    @Column(name = "REMARKS")
    private String remarks; // 비고


    // 사원번호, NOT NULL

}
