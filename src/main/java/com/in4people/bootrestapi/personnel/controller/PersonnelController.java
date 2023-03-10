package com.in4people.bootrestapi.personnel.controller;

import com.in4people.bootrestapi.common.Criteria;
import com.in4people.bootrestapi.common.PageDTO;
import com.in4people.bootrestapi.common.PagingResponseDTO;
import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.personnel.service.PersonnelService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;

    private static final Logger log = LoggerFactory.getLogger(PersonnelController.class);

    @GetMapping("/personnel/{cerCode}")
    public ResponseEntity<ResponseDTO> selectCerInfo(@PathVariable String cerCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", personnelService.selectCerInfo(cerCode)));
    }

    @GetMapping("/personnel/orderInfo")
    public ResponseEntity<ResponseDTO> selectOrderInfoListWithPaging(@RequestParam(name = "offset", defaultValue = "1") String offset ) {

        log.info("[PersonnelController] selectOrderInfoListWithPaging : " + offset);

        int total = personnelService.selectOrderInfoTotal();
        log.info("[PersonnelController] total ================================ " + total);
        Criteria cri = new Criteria(Integer.valueOf(offset), 10);

        PagingResponseDTO pagingResponseDTO = new PagingResponseDTO();

        pagingResponseDTO.setData(personnelService.selectOrderInfoListWithPaging(cri));

        pagingResponseDTO.setPageInfo(new PageDTO(cri, total));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "인사발령리스트 조회 성공", pagingResponseDTO));
    }
}
