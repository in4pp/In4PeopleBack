package com.in4people.bootrestapi.dailyWorker.service;

import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkerDTO;
import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import com.in4people.bootrestapi.dailyWorker.repository.DailyWorkerRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//import static com.sun.java.swing.action.ActionUtilities.IMAGE_DIR;

@Service
public class DailyWorkerService {

    private static final Logger log = LoggerFactory.getLogger(DailyWorkerService.class);
    private final DailyWorkerRepository dailyWorkerRepository;
    private final ModelMapper modelMapper;
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


//    @Transactional
//    public Object insertDailyWorker(DailyWorkerDTO dailyWorkerDTO) {
//        log.info("[ReviewService] insertProductReview Start ==============================");
//
//        int result = 0;
//
//        try {
//            DailyWorker dailyWorker = modelMapper.map(dailyWorkerDTO, DailyWorker.class);
//
//            dailyWorkerRepository.save(dailyWorker);
//
//            result = 1;
//        } catch (Exception e) {
//            log.info("[dailyWorker insert] Exception!!");
//        }
//
//        log.info("[dailyWorkerService] insertDailyWorker End ==============================");
//
//        return (result > 0) ? "리뷰 입력 성공" : "리뷰 입력 실패" ;
//    }


    @Transactional
    public Object insertDailyWorker(DailyWorkerDTO dailyWorkerDTO, MultipartFile productImage) {
        log.info("[ProductService] insertProduct Start ===================================");
        log.info("[ProductService] dailyWorkerDTO : " + dailyWorkerDTO);

        String imageName = UUID.randomUUID().toString().replace("-", "");
        String replaceFileName = null;
        int result = 0;

        try {

            /* util 패키지에 FileUploadUtils 추가 */
            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, productImage);

            dailyWorkerDTO.setProductImageUrl(replaceFileName);

            log.info("[Service] insert Image Name : ", replaceFileName);

            DailyWorkerDTO insertWorker = modelMapper.map(dailyWorkerDTO, DailyWorker.class);

            dailyWorkerRepository.save(insertWorker);

            result = 1;
        } catch (Exception e) {
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? "상품 입력 성공" : "상품 입력 실패";
    }

    @Transactional
    public Object updateDailyWoker(DailyWorkerDTO productDTO, MultipartFile productImage) {
        log.info("[ProductService] updateProduct Start ===================================");
        log.info("[ProductService] productDTO : " + productDTO);

        String replaceFileName = null;
        int result = 0;

        try {

            /* update 할 엔티티 조회 */
            Product product = dailyWorkerRepository.findById(productDTO.getProductCode()).get();
            String oriImage = product.getProductImageUrl();
            log.info("[updateProduct] oriImage : " + oriImage);

            /* update를 위한 엔티티 값 수정 */
            product.setCategoryCode(productDTO.getCategoryCode());
            product.setProductName(productDTO.getProductName());
            product.setProductPrice(productDTO.getProductPrice());
            product.setProductOrderable(productDTO.getProductOrderable());
            product.setCategoryCode(productDTO.getCategoryCode());
            product.setProductStock(productDTO.getProductStock());
            product.setProductDescription(productDTO.getProductDescription());

            if(productImage != null){
                String imageName = UUID.randomUUID().toString().replace("-", "");
                replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, productImage);
                log.info("[updateProduct] InsertFileName : " + replaceFileName);

                product.setProductImageUrl(replaceFileName);	// 새로운 파일 이름으로 update
                log.info("[updateProduct] deleteImage : " + oriImage);

                boolean isDelete = FileUploadUtils.deleteFile(IMAGE_DIR, oriImage);
                log.info("[update] isDelete : " + isDelete);
            } else {

                /* 이미지 변경 없을 시 */
                product.setProductImageUrl(oriImage);
            }

            result = 1;
        } catch (IOException e) {
            log.info("[updateProduct] Exception!!");
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }
        log.info("[ProductService] updateProduct End ===================================");
        return (result > 0) ? "상품 업데이트 성공" : "상품 업데이트 실패";
    }





}
