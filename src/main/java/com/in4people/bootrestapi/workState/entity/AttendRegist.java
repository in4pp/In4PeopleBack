package com.in4people.bootrestapi.workState.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

// 근태 등록 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ATTEND_REGIST")
public class AttendRegist {


    @Id
    @Column(name = "ATTEND_REGIST_NUMBER")
    private String attendRegistNumber;    // 근태번호 PK

    @Column(name = "WORK_DATE")
    private Date workDate;      // 근무일자

    @Column(name = "GET_TO_WORK")
    private Date getToWork;      // 출근시간

    @Column(name = "GET_OFF_WORK")
    private Date getOffWork;      // 퇴근시간


    // FK
    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private WorkMember memCode;    // 사원번호

    @ManyToOne
    @JoinColumn(name = "WORK_STATE_CODE")
    private WorkState workStateCode;  // 근태 상태 코드


}
