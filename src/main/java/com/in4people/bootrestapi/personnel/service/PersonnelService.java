package com.in4people.bootrestapi.personnel.service;

import com.in4people.bootrestapi.personnel.dto.CertificateDTO;
import com.in4people.bootrestapi.personnel.entity.Certificate;
import com.in4people.bootrestapi.personnel.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonnelService {

    private static final Logger log = LoggerFactory.getLogger(PersonnelService.class);

    private final PersonnelRepository personnelRepository;

    private final ModelMapper modelMapper;

    public Object selectCerInfo(String cerCode) {

        Certificate certificate = personnelRepository.findByCerCode(cerCode);
        log.info("[PersonnelService] {}", certificate);

        return modelMapper.map(certificate, CertificateDTO.class);
    }
}
