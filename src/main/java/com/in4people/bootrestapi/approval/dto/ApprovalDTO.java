package com.in4people.bootrestapi.approval.dto;

import com.in4people.bootrestapi.approval.entity.Bookmark;
import com.in4people.bootrestapi.approval.entity.DocAttachment;
import com.in4people.bootrestapi.member.dto.MemberDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApprovalDTO {

    private String docCode;
    private MemberDTO memCode; // memCode FK+PK 상신인
    private String docType;  // 결재종류(ex:업무, 근태)
    private char isApproved; // W/Y/N

    private List<ApproverDTO> approverList; // 결재자 리스트
    private List<RefereeDTO> refereeDTOList; // 참조인 리스트
    private String title; //제목
    private Bookmark bookmark; //
    private List<DocAttachmentDTO> docAttachmentList; // 결재_첨부파일

    
}
