package com.in4peopl.bootrestapi.salary.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IncomeTaxDTO {

    private String incomeTaxCode;                        // 소득세코드
    private int lowerTaxBaseLimit;                       // 과세표준상한
    private int upperTaxBaseLimit;                       // 과세표준하한
    private float taxRate;                               // 세율
    private int deductionAmount;                         // 공제금액






}
