package com.in4peopl.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PerOrderDTO {

    // 인사발령
    private String perCode; // 인사발령코드, PK, NOT NULL

    private String perName; // 인사발령명

}
