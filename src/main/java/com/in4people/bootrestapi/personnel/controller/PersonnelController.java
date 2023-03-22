package com.in4people.bootrestapi.personnel.controller;

import com.in4people.bootrestapi.common.Criteria;
import com.in4people.bootrestapi.common.PageDTO;
import com.in4people.bootrestapi.common.PagingResponseDTO;
import com.in4people.bootrestapi.common.ResponseDTO;
import com.in4people.bootrestapi.personnel.dto.PerOrderAppDTO;
import com.in4people.bootrestapi.personnel.dto.PersonnelApprovalDTO;
import com.in4people.bootrestapi.personnel.dto.PersonnelMemberDTO;
import com.in4people.bootrestapi.personnel.service.PersonnelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value ="/api/v1")
public class PersonnelController {

    private final PersonnelService personnelService;

    private static final Logger log = LoggerFactory.getLogger(PersonnelController.class);

    @Autowired
    public PersonnelController(PersonnelService personnelService){
        this.personnelService = personnelService;
    }

    // 테스트로 해본 DB 출력
    @GetMapping("/personnel/{cerCode}")
    public ResponseEntity<ResponseDTO> selectCerInfo(@PathVariable String cerCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", personnelService.selectCerInfo(cerCode)));
    }

    // 인사발령 리스트 조회
    @GetMapping("/personnel/orderInfo/list")
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
    @GetMapping("/personnel/member/list")
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


    // 인사발령 등록 // Approval테이블 기준으로 두 개 테이블 같이 insert? /////////////////////////// 미구현
    @PostMapping("/personnel/orderApp")
    public ResponseEntity<ResponseDTO> insertOrderApp(@RequestBody PerOrderAppDTO perOrderAppDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "인사발령 등록 성공",  personnelService.insertOrderApp(perOrderAppDTO)));
    }


    // 멤버 등록
    @PostMapping(value = "/personnel/memberRegist")
    public ResponseEntity<ResponseDTO> insertMemberRegist(@ModelAttribute PersonnelMemberDTO personnelMemberDTO, @RequestParam(required = false) MultipartFile memPicture) {
        System.out.println("personnelMemberDTO =========================== " + personnelMemberDTO);

        log.info("memberInsert Controller=========================== " ,personnelMemberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "멤버 등록 성공",  personnelService.insertMemberRegist(personnelMemberDTO, memPicture)));
    }


    // 증명서 신청 등록 후 결재 // Approval테이블 기준으로 두 개 테이블 같이 insert? /////////////////////////// 미구현
    @PostMapping("/personnel/cerApp")
    public ResponseEntity<ResponseDTO> insertcerApp(@RequestBody PersonnelApprovalDTO personnelApprovalDTO) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "증명서 신청 등록 성공",  personnelService.insertcerApp(personnelApprovalDTO)));
    }


    // 멤버들끼리 서로 볼 수 있는 상세 페이지 조회
    @GetMapping("/personnel/memDetail/{memCode}")
    public ResponseEntity<ResponseDTO> selectMemberDetail(@PathVariable String memCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공",  personnelService.selectMemberDetail(memCode)));
    }


    // 본인 인사 정보 페이지 조회하여 수정하려고 만듦
    @GetMapping("/personnel/memberUpdate/{memCode}")
    public ResponseEntity<ResponseDTO> selectMemberUpdate(@PathVariable String memCode) {

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공",  personnelService.selectMemberUpdate(memCode)));
    }


    // 멤버 정보 수정
    @PutMapping(value = "/personnel/memberUpdate")
    public ResponseEntity<ResponseDTO> updateMember(@ModelAttribute PersonnelMemberDTO personnelMemberDTO, @RequestParam(required = false) MultipartFile memPicture) {
        System.out.println("personnelMemberDTO =========================== " + personnelMemberDTO);

        log.info("memberUpdate Controller=========================== " ,personnelMemberDTO);

        log.info("memCode : " +personnelMemberDTO.getMemCode() );
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "멤버 수정 성공",  personnelService.updateMember(personnelMemberDTO, memPicture)));
    }


    // 사원 명부 검색 기능
    @GetMapping("/personnel/search/{memName}")
    public ResponseEntity<ResponseDTO> selectSearchMemberList(@PathVariable String memName) {

        System.out.println("[Controller] memName = " + memName);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "검색 성공", personnelService.selectSearchMemberList(memName)));
    }
}