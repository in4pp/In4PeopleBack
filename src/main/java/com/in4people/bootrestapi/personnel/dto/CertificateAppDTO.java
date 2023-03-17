package com.in4people.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CertificateAppDTO {

    // 증명서 신청

    private Long idNum; // 신청번호, PK, NOT NULL

    private String docCode; // 문서번호, NOT NULL

    private CertificateDTO cerCode; // 증명서 코드, NOT NULL

}
