package com.in4people.bootrestapi.dailyWorker.service;

import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkerDTO;
import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import com.in4people.bootrestapi.dailyWorker.repository.DailyWorkerRepository;
import com.in4people.bootrestapi.util.FileUploadUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class DailyWorkerService {

    private static final Logger log = LoggerFactory.getLogger(DailyWorkerService.class);
    private final DailyWorkerRepository dailyWorkerRepository;
    private final ModelMapper modelMapper;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;

    @Autowired
    public DailyWorkerService(DailyWorkerRepository dailyWorkerRepository, ModelMapper modelMapper) {
        this.dailyWorkerRepository = dailyWorkerRepository;
        this.modelMapper = modelMapper;
    }


    public List<DailyWorkerDTO> selectDailyWorkerInfo(String workerName) {
        List<DailyWorker> dWorkerList = dailyWorkerRepository.findByworkerNameContaining(workerName);
        return dWorkerList.stream().map(d -> modelMapper.map(d, DailyWorkerDTO.class)).collect(Collectors.toList());
    }


    public Object selectDailyWorkerInfoAll() {

        log.info("[dailyWorkerService] start ============================ ");

        List<DailyWorker> dailyWorkerList = dailyWorkerRepository.findAll();
        log.info("[dailyWorkerService] end ============================ ");

        return dailyWorkerList.stream().map(dailyWorker -> modelMapper.map(dailyWorker, DailyWorker.class)).collect(Collectors.toList());

    }


    @Transactional
    public Object insertDailyWorker(DailyWorkerDTO dailyWorkerDTO, MultipartFile workerPic) {
        log.info("[Service] dailyWorkerService insert Start ===================================");
        log.info("[Service] dailyWorkerDTO : " + dailyWorkerDTO);

        String imageName = UUID.randomUUID().toString().replace("-", "");
        log.info("imageName : " + imageName);
        String replaceFileName = null;
        int result = 0;


        try {
            log.info("workerPic : " + workerPic);
            /* util 패키지에 FileUploadUtils 추가 */
            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, workerPic);

           dailyWorkerDTO.setPictureUrl(replaceFileName);

            log.info("[Service] insert Image Name : ", replaceFileName);

            DailyWorker insertWorker = modelMapper.map(dailyWorkerDTO, DailyWorker.class);

            log.info("[Service] dailyWorker : ", insertWorker);

            dailyWorkerRepository.save(insertWorker);

            result = 1;
        } catch (Exception e) {
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }
        log.info("[Service] dailyWorkerService insert End ==============================");

        return (result > 0) ? "사원등록 성공" : "사원등록 실패";
    }

    public Object selectWorkerDetail(int workerCode) {
        log.info("[dailyWorkerService] selectDWorkerDetail Start ==============================");
        log.info("[dailyWorkerService] workerCode : " + workerCode);
        DailyWorker dailyWorker = dailyWorkerRepository.findById(workerCode).get();
        dailyWorker.setPictureUrl(IMAGE_URL + dailyWorker.getPictureUrl());

        log.info("[dailyWorkerService] selectDWorkerDetail End ==============================");

//        DailyWorkerDTO dailyWorkerDTO = modelMapper.map(dailyWorker, DailyWorkerDTO.class);

        return modelMapper.map(dailyWorker, DailyWorker.class);
    }


    @Transactional
    public Object updateDailyWoker(DailyWorkerDTO dailyWorkerDTO, MultipartFile workerPic) {
        log.info("[Service] updateDailyWoker Start ===================================");
        log.info("[Service] dailyWorkerDTO : " + dailyWorkerDTO);

        String replaceFileName = null;
        int result = 0;

        try {

            /* update 할 엔티티 조회 */
            DailyWorker dailyWorker = dailyWorkerRepository.findByWorkerCode(dailyWorkerDTO.getWorkerCode());

            System.out.println("dailyWorker =============== " + dailyWorker);

            String imageurl = dailyWorker.getPictureUrl();
            log.info("[update] imageurl : " + imageurl);

            /* update를 위한 엔티티 값 수정 */
            dailyWorker.setWorkerName(dailyWorkerDTO.getWorkerName());
            dailyWorker.setWorkerRegNumber(dailyWorkerDTO.getWorkerRegNumber());
            dailyWorker.setWorkerPhone(dailyWorkerDTO.getWorkerPhone());
            dailyWorker.setWorkerAddress(dailyWorkerDTO.getWorkerAddress());
            dailyWorker.setStartDate(dailyWorkerDTO.getStartDate());
            dailyWorker.setEndDate(dailyWorkerDTO.getEndDate());
            dailyWorker.setWorkerEmail(dailyWorkerDTO.getWorkerEmail());
            dailyWorker.setBank(dailyWorkerDTO.getBank());
            dailyWorker.setAccountNumber(dailyWorkerDTO.getAccountNumber());


            if(workerPic != null){
                String imageName = UUID.randomUUID().toString().replace("-", "");
                replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, workerPic);
                log.info("[updateProduct] InsertFileName : " + replaceFileName);

                dailyWorker.setPictureUrl(replaceFileName);	// 새로운 파일 이름으로 update
                log.info("[updateProduct] deleteImage : " + imageurl);

                boolean isDelete = FileUploadUtils.deleteFile(IMAGE_DIR, imageurl);
                log.info("[update] isDelete : " + isDelete);
            } else {

                /* 이미지 변경 없을 시 */
                dailyWorker.setPictureUrl(imageurl);
            }

            result = 1;
        } catch (IOException e) {
            log.info("[updateProduct] Exception!!");
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }
        log.info("[ProductService] updateProduct End ===================================");
        return (result > 0) ? "업데이트 성공" : "업데이트 실패";
    }

}

