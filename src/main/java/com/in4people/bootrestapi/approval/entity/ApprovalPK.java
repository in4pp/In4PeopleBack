package com.in4people.bootrestapi.approval.entity;


import com.in4people.bootrestapi.member.entity.Member;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ApprovalPK implements Serializable {

    private String docCode;

    private Member memCode; //상신인
}
