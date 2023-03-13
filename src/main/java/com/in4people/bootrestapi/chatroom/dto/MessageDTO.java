package com.in4people.bootrestapi.chatroom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDTO {

    private int msgId;

    private int chatRoomId ;

    private String chatSenderId;

    private String chatContent;

}
