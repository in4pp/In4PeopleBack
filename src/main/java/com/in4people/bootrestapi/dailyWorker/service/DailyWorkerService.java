package com.in4people.bootrestapi.dailyWorker.service;

import com.in4people.bootrestapi.dailyWorker.dto.DailyWorkerDTO;
import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import com.in4people.bootrestapi.dailyWorker.repository.DailyWorkerRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public DailyWorkerDTO selectDailyWorkerInfo(int workerCode) {

        log.info("[MemberService] getMyInfo Start =======================");

        DailyWorker dailyWorker = dailyWorkerRepository.findByWorkerCode(workerCode);
        log.info("[MemberService] {}", dailyWorker);
        log.info("[MemberService] getMyInfo End =========================");

        return modelMapper.map(dailyWorker, DailyWorkerDTO.class);


    }
}
