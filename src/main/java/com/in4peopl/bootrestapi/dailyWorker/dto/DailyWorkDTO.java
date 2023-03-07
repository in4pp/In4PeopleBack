package com.in4peopl.bootrestapi.dailyWorker.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkDTO {
    private int workCode;
    private Date startDate;
    private Date endDate;
    private String department;
    private Date workingTime;
    private Date createAt;
    private Date updatedAt;

}
