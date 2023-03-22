package com.in4people.bootrestapi.approval.entity;


import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="APPROVER")
@DynamicInsert
@DynamicUpdate
public class Approver {

    @Id
    @Column(name = "DOC_CODE")
    private String docCode;

    @Column(name = "MEM_CODE")
    private String memCode; // 결재자 memCode

    @Column(name = "IS_SIGN")
    private char isSign; // W/Y/N(대기,승인,반려)

    @Column(name = "PROCESSED_DATE")
    private Date processedDate; // 처리된 날짜

    @Column(name = "OPINION")
    private String opinion; // 결재 의견
}
