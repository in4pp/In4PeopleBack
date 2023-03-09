package com.in4people.bootrestapi.approveWork.dto;


import lombok.*;

// 전자 결제 승인 DTO
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApprovedCategoryDTO {

    private String approvedCode;  // 결제 상태 코드 PK

    private String approvedName;// 결제 상태 이름
}
