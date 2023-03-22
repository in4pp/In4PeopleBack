package com.in4people.bootrestapi.personnel.dto;

import com.in4people.bootrestapi.approval.dto.DocAttachmentDTO;
import com.in4people.bootrestapi.approval.dto.RefereeDTO;
import com.in4people.bootrestapi.approval.entity.Bookmark;
import com.in4people.bootrestapi.personnel.entity.CcApp;
import com.in4people.bootrestapi.personnel.entity.PerOrderApp;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CcAppApprovalDTO {

    private String docCode;
    private PersonnelMemberDTO memCode; // memCode FK+PK 상신인
    private String docType;  // 결재종류(ex:업무, 근태)
    private String isApproved; // W/Y/N

    private List<CcAppApprovalDTO> approverList; // 결재자 리스트
    private List<RefereeDTO> refereeDTOList; // 참조인 리스트
    private String title; //제목
    private Bookmark bookmark; //
    private List<DocAttachmentDTO> docAttachmentList; // 결재_첨부파일
//    private List<PerOrderApp> perOrderAppList;
    private CcApp ccApp;

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "DOC_CODE")
//    private CcApp ccCode;
}