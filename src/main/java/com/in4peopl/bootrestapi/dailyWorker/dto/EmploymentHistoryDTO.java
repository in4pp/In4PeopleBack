package com.in4peopl.bootrestapi.dailyWorker.dto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmploymentHistoryDTO  {

    private int workCode;        //근무코드

    private int workerCode;      //일용직사원 코드

}
