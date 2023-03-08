package com.in4people.bootrestapi.dailyWorker.dto;
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
