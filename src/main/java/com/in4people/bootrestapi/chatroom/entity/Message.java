package com.in4people.bootrestapi.chatroom.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MSG_ID")
public class Message {
    @Id
    @Column(name = "CHAT_ROOM_ID")
    private int chatRoomId;

    @Column(name = "CHAT_SENDER_ID")
    private String chatSenderId;


    @Column(name = "CHAT_CONTENT")
    private String chatContent;


}
