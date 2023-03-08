package com.in4peopl.bootrestapi.personnel.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CertificateAppDTO {

    // 증명서 신청


//    private // 결재 FK

    private String cerReason; // 사유

    private CertificateDTO cerCode; // 증명서 코드, FK, NOT NULL

}
