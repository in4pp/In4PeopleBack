package com.in4people.bootrestapi.approveWork.service;

import com.in4people.bootrestapi.approveWork.dto.WorkSettingDTO;
import com.in4people.bootrestapi.approveWork.entity.WorkSetting;
import com.in4people.bootrestapi.approveWork.repository.ApproveworkRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SettingService {

    private static final Logger log = LoggerFactory.getLogger(SettingService.class);

    private final ApproveworkRepository approveworkRepository;

    private final ModelMapper modelMapper;

    public Object selectWorkSetting(String workSettingNumber) {

        log.info("SettingService selectWorkSetting Start =============");

        WorkSetting workset = approveworkRepository.findByWorkSettingNumber(workSettingNumber);

        log.info("[SettingService] {}" , workset);
        log.info("[SettingService] selectWorkSetting End ======");


        return modelMapper.map(workset, WorkSettingDTO.class);
    }


}
