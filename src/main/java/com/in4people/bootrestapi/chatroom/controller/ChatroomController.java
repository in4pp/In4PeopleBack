package com.in4people.bootrestapi.chatroom.controller;

import com.in4people.bootrestapi.chatroom.dto.ChatroomDTO;
import com.in4people.bootrestapi.chatroom.dto.MessageDTO;
import com.in4people.bootrestapi.chatroom.entity.Chatroom;
import com.in4people.bootrestapi.chatroom.service.ChatroomService;
import com.in4people.bootrestapi.common.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Controller
@RestController
@RequestMapping("/api/v1")
public class ChatroomController {


    @GetMapping("/rooms")
    public String getRooms() {
        return "chat/rooms";
    }

  //  @GetMapping(value = "/room")
//    public int getRoom(Long chatRoomId, String nickname, Model model) {


     //   model.addAttribute("chatRoomId", chatRoomId);
      //  model.addAttribute("nickname", nickname);

       // return "chat/room";
    }

//}

//    @Autowired
//    private Chatroom chatroom;

