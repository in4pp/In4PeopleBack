package com.in4people.bootrestapi.approveWork.service;

import com.in4people.bootrestapi.approveWork.dto.DocumentApprovalDTO;
import com.in4people.bootrestapi.approveWork.entity.DocumentApproval;
import com.in4people.bootrestapi.schedule.dto.WorkSettingDTO;
import com.in4people.bootrestapi.schedule.entity.WorkSetting;
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


    public Object selectDocumentApproval(String documentNumber) {

        log.info("SettingService selectDocumentApproval Start =============");

        DocumentApproval document = approveworkRepository.findByDocumentNumber(documentNumber);

        log.info("[SettingService] {}" , document);
        log.info("[SettingService] selectWorkSetting End ======");


        return modelMapper.map(document, DocumentApprovalDTO.class);
    }

    public Object insertDocument(DocumentApprovalDTO newDocu) {

        log.info("SettingService insertDocumentApproval Start =============");

        DocumentApproval insertDocu = modelMapper.map(newDocu, DocumentApproval.class);

        DocumentApproval document = approveworkRepository.save(insertDocu);

        log.info("[SettingService] {}" , document);
        log.info("[SettingService] insertDocumentApproval End ======");


        return modelMapper.map(document, DocumentApprovalDTO.class);
    }
}
