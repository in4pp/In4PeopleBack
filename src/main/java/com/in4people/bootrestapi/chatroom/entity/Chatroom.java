package com.in4people.bootrestapi.chatroom.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CHATROOM")
public class Chatroom {
    @Id
    @Column(name = "CHAT_ROOM_ID")
    private int chatRoomId;

    @Column(name = "CHAT_SENDER_ID")
    private String chatSenderId;


    @Column(name = "CHAT_RECEIVER_ID")
    private String chatReceiverId;


}
