package com.in4people.bootrestapi.approval.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;


@Embeddable // 복합키 타입을 지정할 때 사용하는 어노테이션
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DocPK implements Serializable {

    @Column(name ="DOC_CODE")
    private String docCode;

    @Column(name ="MEM_CODE")
    private String memCode; // 참조인 memCode
}
