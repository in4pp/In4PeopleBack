package com.in4people.bootrestapi.salary.service;

import com.in4people.bootrestapi.salary.dto.EmployeeSalarySettingDTO;
import com.in4people.bootrestapi.salary.dto.IncomeTaxDTO;
import com.in4people.bootrestapi.salary.entity.EmployeeSalarySetting;
import com.in4people.bootrestapi.salary.entity.IncomeTax;
import com.in4people.bootrestapi.salary.repository.EmployeeSalarySettingRepository;
import com.in4people.bootrestapi.salary.repository.SalaryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SalaryService {

    private static final Logger log = LoggerFactory.getLogger(SalaryService.class);
    private final SalaryRepository salaryRepository;
    private final ModelMapper modelMapper;
    private final EmployeeSalarySettingRepository employeeSalarySettingRepository;




    public Object selectIncomeTax() {
        log.info(("[SalaryService] selectIncomeTax Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));

        List<IncomeTax> incomeTaxList = salaryRepository.findAll();

        log.info("[SalaryService] {}", incomeTaxList);
        log.info(("[SalaryService] selectIncomeTax End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑"));

        return incomeTaxList.stream().map(incomeTax -> modelMapper.map(incomeTax, IncomeTaxDTO.class)).collect(Collectors.toList());

//        return modelMapper.map(incomeTaxList, IncomeTaxDTO.class);


    }

    public Object selectSalarySetting() {
        log.info(("[SalaryService] selectIncomeTax Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));

        List<EmployeeSalarySetting> employeeSalarySettingList = employeeSalarySettingRepository.findAll();

        log.info("[SalaryService] {}", employeeSalarySettingList);
        log.info(("[SalaryService] selectIncomeTax End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑"));

        return employeeSalarySettingList.stream().map(employeeSalarySetting -> modelMapper.map(employeeSalarySetting, EmployeeSalarySettingDTO.class)).collect(Collectors.toList());

    }

}
