package com.in4people.bootrestapi.schedule.service;

import com.in4people.bootrestapi.schedule.dto.WorkSettingDTO;
import com.in4people.bootrestapi.schedule.entity.WorkSetting;
import com.in4people.bootrestapi.schedule.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService {


    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    private final ScheduleRepository scheduleRepository;

    private final ModelMapper modelMapper;


    public Object selectWorkSetting(String workSettingNumber) {

        log.info("ScheduleService selectWorkSetting Start =============");

        WorkSetting workset = scheduleRepository.findByWorkSettingNumber(workSettingNumber);

        log.info("[SettingService] {}" , workset);
        log.info("[SettingService] selectWorkSetting End ======");


        return modelMapper.map(workset, WorkSettingDTO.class);
    }
}
