package com.in4people.bootrestapi.personnel.controller;

import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.personnel.service.PersonnelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;

    @GetMapping("/personnel/{cerCode}")
    public ResponseEntity<ResponseDTO> selectCerInfo(@PathVariable String cerCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", personnelService.selectCerInfo(cerCode)));
    }
}
