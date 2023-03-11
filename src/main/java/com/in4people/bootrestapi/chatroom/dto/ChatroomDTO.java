package com.in4people.bootrestapi.chatroom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatroomDTO {

    private int chatRoomId;

    private String chatSenderId;

    private String chatReceiverId;

}
