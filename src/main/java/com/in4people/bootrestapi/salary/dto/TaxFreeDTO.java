package com.in4people.bootrestapi.salary.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TaxFreeDTO {

    private String taxFreeCode;
    private String taxFreeName;
    private String explanation;

}
