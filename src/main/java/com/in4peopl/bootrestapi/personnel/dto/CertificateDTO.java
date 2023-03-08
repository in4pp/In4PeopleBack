package com.in4peopl.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CertificateDTO {

    // 증명서
    private String cerCode; // 증명서코드, PK, NOT NULL

    private String cerName; // 증명서명

}
