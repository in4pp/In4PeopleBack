package com.in4people.bootrestapi.approval.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name ="DOC_ATTACHMENT")
public class DocAttachment {

    @Id
    @Column(name = "ATTACH_NO")
    private int attachNo; // 시퀀스

    @Column(name = "DOC_CODE")
    private String docCode;

    @Column(name = "FILE_NAME")
    private String fileName; // 파일이름

    @Column(name = "URL")
    private String url; // 파일주소

    @Column(name = "PATHNAME")
    private String pathName; //저장이름
}
