package com.in4people.bootrestapi.schedule.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 근무 유형 카테고리 entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "WORKTYPE_CATEGORY")
public class WorktypeCategory {

    @Id
    @Column(name = "WORKTYPE_CODE")
    private String worktypeCode;   // 근무 유형 코드  PK

    @Column(name = "WORKTYPE_NAME")
    private String worktypeName; // 근무 유형 이름


}
