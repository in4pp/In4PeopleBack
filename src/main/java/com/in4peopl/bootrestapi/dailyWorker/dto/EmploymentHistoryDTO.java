package com.in4peopl.bootrestapi.dailyWorker.dto;
import lombok.*;

import java.sql.Date;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmploymentHistoryDTO {

    private DailyWorkerDTO dailyWorker;
    private DailyWorkDTO dailyWork;
    private Date createAt;
}
