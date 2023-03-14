package com.in4people.bootrestapi.approveWork.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 휴가 종류 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "VACATION_CATEGORY")
public class VacationCategory {

    @Id
    @Column(name = "VACATION_CODE")
    private String vacationCode;   // 휴가 코드 PK

    @Column(name = "VACATION_NAME")
    private String vacationName;   // 휴가 이름


}
