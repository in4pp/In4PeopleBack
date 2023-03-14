package com.in4people.bootrestapi.personnel.controller;

import com.in4people.bootrestapi.common.Criteria;
import com.in4people.bootrestapi.common.PageDTO;
import com.in4people.bootrestapi.common.PagingResponseDTO;
import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.personnel.dto.PerOrderAppDTO;
import com.in4people.bootrestapi.personnel.dto.PersonnelMemberDTO;
import com.in4people.bootrestapi.personnel.service.PersonnelService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value ="/api/v1", method = {RequestMethod.GET, RequestMethod.POST})
@AllArgsConstructor
public class PersonnelController {

    private final PersonnelService personnelService;

    private static final Logger log = LoggerFactory.getLogger(PersonnelController.class);

    // 테스트로 해본 DB 출력
    @GetMapping("/personnel/{cerCode}")
    public ResponseEntity<ResponseDTO> selectCerInfo(@PathVariable String cerCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", personnelService.selectCerInfo(cerCode)));
    }

    // 인사발령 리스트 조회
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

    // 재직중인 멤버리스트 조회
    @GetMapping("/personnel/member")
    public ResponseEntity<ResponseDTO> selectMemberListWithPaging(@RequestParam(name = "offset", defaultValue = "1") String offset ) {

        log.info("[PersonnelController] selectMemberListWithPaging : " + offset);

        int total = personnelService.selectMemberTotal();
        log.info("[PersonnelController] total ================================= " + total);
        Criteria cri = new Criteria(Integer.valueOf(offset), 10);

        PagingResponseDTO pagingResponseDTO = new PagingResponseDTO();

        pagingResponseDTO.setData(personnelService.selectMemberListWithPaging(cri));

        pagingResponseDTO.setPageInfo(new PageDTO(cri, total));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "인사리스트 조회 성공", pagingResponseDTO));
    }


    // 인사발령 등록 // Approval테이블 기준으로 두 개 테이블 같이 insert?
    @PostMapping("/personnel/orderApp")
    public ResponseEntity<ResponseDTO> insertOrderApp(@RequestBody PerOrderAppDTO perOrderAppDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "인사발령 등록 성공",  personnelService.insertOrderApp(perOrderAppDTO)));
    }


    // 멤버 등록
    @PostMapping("/personnel/memberRegist")
    public ResponseEntity<ResponseDTO> insertMemberRegist(@RequestBody PersonnelMemberDTO personnelMemberDTO) {
        System.out.println("personnelMemberDTO =========================== " + personnelMemberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "멤버 등록 성공",  personnelService.insertMemberRegist(personnelMemberDTO)));
    }

}
