package com.in4people.bootrestapi.workState.entity;

// 근태 상태 entity

import lombok.*;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "WORK_STATE")
public class WorkState {


    @Id
    @Column(name = "WORK_STATE_CODE")
    private String workStateCode;  // 근태 상태 코드 PK

    @Column(name = "WORK_STATE_NAME")
    private String workStateName;  // 근태 상태 이름



}
