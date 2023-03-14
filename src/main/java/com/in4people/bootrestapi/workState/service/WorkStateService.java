package com.in4people.bootrestapi.workState.service;

import com.in4people.bootrestapi.workState.repository.WorkStateRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class WorkStateService {

    private static final Logger log = LoggerFactory.getLogger(WorkStateService.class);

    private final WorkStateRepository workStateRepository;

    private final ModelMapper modelMapper;
}
