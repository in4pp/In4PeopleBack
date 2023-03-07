package com.in4peopl.bootrestapi.salary.dto;

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
