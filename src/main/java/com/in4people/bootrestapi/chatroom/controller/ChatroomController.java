package com.in4people.bootrestapi.chatroom.controller;

import com.in4people.bootrestapi.chatroom.dto.MessageDTO;
import com.in4people.bootrestapi.chatroom.entity.Chatroom;
import com.in4people.bootrestapi.common.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatroomController {

//    @Autowired
//    private Chatroom chatroom;

    // 1. 사용자가 채팅을 시작 ==> 내부적으로는 채팅방을 추가

    // 2. 채팅방이 만들어지면 해당 방의 아이드를 가지고서 채팅정보를 주고받는 기능
    @PostMapping("/message")
    public ResponseEntity<ResponseDTO> sendMessage(@RequestParam MessageDTO chatMessage) {
       // chatService.sendMessage(chatMessage);
        System.out.println("chatMessage =============== " + chatMessage);
        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK, "메세지전송 성공", "success"));
    }

//    @GetMapping("/messages")
//    public ResponseEntity<List<ChatMessage>>
//    getMessages(@RequestParam Long roomId){
//        List<ChatMessage> messages= chatService.getMessageByRoomId(roomId);
//        return ResponseEntity.ok(messages);
//    }
}
