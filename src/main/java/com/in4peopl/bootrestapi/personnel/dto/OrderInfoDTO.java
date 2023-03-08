package com.in4peopl.bootrestapi.personnel.dto;

import com.in4peopl.bootrestapi.member.dto.MemberDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderInfoDTO {

    // 발령정보

    private int orderNumber; // 발령번호, PK, NOT NULL

    private String orderDetails; // 발령내용

    private String remarks; // 비고

    private MemberDTO memCode; // 사원번호, FK, NOT NULL

}
