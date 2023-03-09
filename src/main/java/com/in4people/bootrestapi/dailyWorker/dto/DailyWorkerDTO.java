package com.in4people.bootrestapi.dailyWorker.dto;

import com.in4people.bootrestapi.salary.dto.EmployeeSalarySettingDTO;
import lombok.*;

import javax.persistence.Embeddable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerDTO  {

    private int workerCode;                 //일용직사원 코드
    private String workerName;              //이름
    private String workerRegNumber;         //주민번호
    private String workerPhone;             //폰번호
    private String workerAddress;           //주소
    private Date createAt;                  //생성시간
    private Date updatedAt;                 //수정시간
    private EmployeeSalarySettingDTO employeeSalarySetting;    //급여설정


}
