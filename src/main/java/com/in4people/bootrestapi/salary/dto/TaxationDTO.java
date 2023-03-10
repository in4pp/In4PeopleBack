package com.in4people.bootrestapi.salary.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaxationDTO {

    private String taxationCode;
    private String taxationName;
    private float taxRate;


}
