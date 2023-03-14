package com.in4people.bootrestapi.personnel.entity;

import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CAREER_INFO")
@SequenceGenerator(
        name = "CAREER_SEQ_GENERATOR",
        sequenceName = "SEQ_CAREER_CODE",
        initialValue = 1, allocationSize = 1
)
public class CareerInfo {

    // 경력정보
    @Id
    @Column(name = "CAREER_NUMBER")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CAREER_SEQ_GENERATOR"
    )
    private Long careerNumber; // PK, NOT NULL, 경력번호

    @Column(name = "CORPORATE_NAME")
    private String corporateName; // 회사명

    @Column(name = "ENTERING_DATE")
    private Date enteringDate; // 입사일자

    @Column(name = "RETIREMENT_DATE")
    private Date retirementDate; // 퇴직일자

    @Column(name = "POSITION")
    private String position; // 직급

    @Column(name = "WORKING_DEPARTMENT")
    private String workingDepartment; // 근무부서

    @Column(name = "REASONS_RETIREMENT")
    private String reasonsRetirement; // 퇴직사유

//     사원번호
    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private Member member;

}
