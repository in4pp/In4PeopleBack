package com.in4people.bootrestapi.dailyWorker.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkDTO {
    private int workCode;         //근무코드
    private Date startDate;       //근무시작일
    private Date endDate;         //근무종료일
    private String department;    //부서
    private Date workingTime;     //근무시간
    private Date createAt;        //생성시간
    private Date updatedAt;       //수정시간


}


