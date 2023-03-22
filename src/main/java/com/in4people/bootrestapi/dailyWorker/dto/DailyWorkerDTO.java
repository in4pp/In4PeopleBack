package com.in4people.bootrestapi.dailyWorker.dto;

import com.in4people.bootrestapi.salary.dto.EmployeeSalarySettingDTO;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerDTO {

    private int workerCode;                 //일용직사원 코드
    private String workerName;              //이름
    private String workerRegNumber;         //주민번호
    private String workerPhone;             //폰번호
    private String workerAddress;           //주소
    private String startDate;               //근무시작일
    private String endDate;                 //근무종료일
    private String pictureUrl;              //사진
    private String workerEmail;             //이메일
    private String bank;                    //은행
    private String accountNumber;           //계좌번호

//    private EmployeeSalarySettingDTO employeeSalarySetting;    //급여설정



}
