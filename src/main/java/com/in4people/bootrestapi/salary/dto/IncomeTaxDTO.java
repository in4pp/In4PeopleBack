package com.in4people.bootrestapi.salary.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IncomeTaxDTO {

    private String incomeTaxCode;                        // 소득세코드
    private long lowerTaxBaseLimit;                       // 과세표준상한
    private long upperTaxBaseLimit;                       // 과세표준하한
    private double taxRate;                               // 세율
    private long deductionAmount;                         // 공제금액



}
