package com.in4people.bootrestapi.vacation.service;

import com.in4people.bootrestapi.vacation.repository.VacationRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VacationService {

    private static final Logger log = LoggerFactory.getLogger(VacationService.class);

    private final VacationRepository vacationRepository;

    private final ModelMapper modelMapper;
}
