package com.in4people.bootrestapi.approveWork.entity;



import com.in4people.bootrestapi.workState.entity.WorkMember;
import lombok.*;

import javax.persistence.*;

// 상신자 태그 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "REPORTER_TAG")
public class ReporterTag {

    @Id
    @Column(name = "REPORTER_TAG_CODE")
    private String reporterTagCode;   // 상신자 태그 코드 FK

    @ManyToOne
    @JoinColumn(name = "MEM_CODE")
    private WorkMember memCode;           // 사원번호 PK

}
