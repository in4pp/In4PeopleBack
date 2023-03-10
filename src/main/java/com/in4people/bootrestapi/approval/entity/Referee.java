package com.in4people.bootrestapi.approval.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="REFEREE")
public class Referee {

    @Id
    @Column(name ="DOC_CODE")
    private String docCode;

    @Column(name ="MEM_CODE")
    private String memCode; // 참조인 memCode

}


