package com.in4people.bootrestapi.approval.dto;

import com.in4people.bootrestapi.approval.entity.Approval;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookmarkDTO {

    private String docCode; //  문서번호
    private String memCode; // 북마크 한 사람
}
