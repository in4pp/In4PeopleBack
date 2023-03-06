package com.in4peopl.bootrestapi.position.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Position {

    private String positionCode; // 직급 코드 PK
    private String positionName; // 직급명
}
