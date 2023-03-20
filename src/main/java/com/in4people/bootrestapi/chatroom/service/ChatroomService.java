package com.in4people.bootrestapi.chatroom.service;


import com.in4people.bootrestapi.chatroom.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.transaction.Transactional;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ChatroomService {

   // private final org.springframework.data.Redis.core.RedisTemplate<String, MessageDTO> chatTemplate;

   // private final Chatemplate<String, String> Chatemplate;

 //   public void addChat(MessageDTO MessageDTO) {

      //  MessageDTO saveData =
      //          MessageDTO.createMessageDTO(messageDTO);

       // Chatemplate.opsForzSet()
             //   .add(
            //            NEW_CHAT,
                      //  saveData,
                   //     chatUtils.changeLocalDateTimeToDouble(savedData, getCreatedAt()));
 //   }
           //     public Double changeLocalDateTimeToDouble(String createdAt) {

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
                //    LocalDateTime localDateTime = LocalDateTime.parse(createdAt, fromatter);
                 //   return ((Long) localDateTime.atZone(ZoneId,systemDefault()).toInstant().toEpochMilli()).doubleValue();


  //  }
}
