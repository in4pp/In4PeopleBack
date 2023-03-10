package com.in4people.bootrestapi.dailyWorker.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DailyWorkerSalaryDTO {
    private int salaryCode;         //급여코드
    private int totalPayment;       //총지급액
    private int afterTaxIncome;     //실수령액
    private Date paymentDate;       //지급일
    private char payCompleteYn;     //지급완료여부
    private int tax;                //근로소득세
    private Date createAt;          //생성시간
    private Date updatedAt;         //수정시간
    private DailyWorkerDTO dailyWorker;     //일용직사원

}
