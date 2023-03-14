package com.in4people.bootrestapi.approveWork.entity;

import com.in4people.bootrestapi.approveWork.dto.AlldayCategoryDTO;
import com.in4people.bootrestapi.approveWork.dto.DocumentApprovalDTO;
import com.in4people.bootrestapi.approveWork.dto.ReporterTagDTO;
import com.in4people.bootrestapi.approveWork.dto.VacationCategoryDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

//휴가 신청 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "APPLICATION_VACATION")
public class ApplicationVacation {

    @Id
    @Column(name = "VACATION_NUBER")
    private String vacationNumber;          // 휴가 신청 번호 PK

    @Column(name = "VACATION_APPLICATION_DATE")
    private Date vacationApplicationDate;   // 신청일

    @Column(name = "VACATION_START_DATE")
    private Date vacationStartDate;         // 휴가 시작 기간

    @Column(name = "VACATION_END_DATE")
    private Date vacationEndDate;           // 휴가 종료 기간

    @Column(name = "VACATION_REASON")
    private String vacationReason;          // 휴가 사유

    // FK
    @ManyToOne
    @JoinColumn(name = "VACATION_CODE")
    private VacationCategory vacationCode;            // 휴가 코드


    @ManyToOne
    @JoinColumn(name = "ALLDAY_CODE")
    private AlldayCategory alldayCode;              // 전일/반일 코드

    @ManyToOne
    @JoinColumn(name = "REPORTER_TAG_CODE")
    private ReporterTag reporterTagCode;         // 상신자 태그 코드

    @OneToOne
    @JoinColumn(name = "DOCUMENT_NUMBER")
    private DocumentApproval documentNumber;          // 전자 결제 번호

}
