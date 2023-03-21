package com.in4people.bootrestapi.approval.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RefereeDTO {

    private String docCode;
    private String memCode; // 북마크한 사람(로그인한사람의 memCode)
}