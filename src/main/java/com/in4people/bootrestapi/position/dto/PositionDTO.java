package com.in4people.bootrestapi.position.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PositionDTO {

    private String positionCode; // 직급 코드 PK
    private String positionName; // 직급명
}
