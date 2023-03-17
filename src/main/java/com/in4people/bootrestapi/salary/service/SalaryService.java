package com.in4people.bootrestapi.salary.service;

import com.in4people.bootrestapi.salary.dto.EmpSalSettingDTO;
import com.in4people.bootrestapi.salary.dto.EmployeeSalarySettingDTO;
import com.in4people.bootrestapi.salary.dto.IncomeTaxDTO;
import com.in4people.bootrestapi.salary.dto.SalsetMemberDTO;
import com.in4people.bootrestapi.salary.entity.EmployeeSalarySetting;
import com.in4people.bootrestapi.salary.entity.IncomeTax;
import com.in4people.bootrestapi.salary.entity.SalsetMember;
import com.in4people.bootrestapi.salary.repository.EmployeeSalarySettingRepository;
import com.in4people.bootrestapi.salary.repository.SalaryRepository;
import com.in4people.bootrestapi.salary.repository.SalsetRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SalaryService {

    private static final Logger log = LoggerFactory.getLogger(SalaryService.class);
    private final SalaryRepository salaryRepository;
    private final ModelMapper modelMapper;
    private final EmployeeSalarySettingRepository employeeSalarySettingRepository;
    private final SalsetRepository salsetRepository;







    public Object selectHourlysetMember(String memCode) {
        log.info(("[SalaryService] selectHourlysetMember Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));

        SalsetMember salsetMember = salsetRepository.findByMemCode(memCode);

        log.info("[SalaryService] {}", salsetMember);
        log.info("[SalaryService] selectHourlysetMember End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");

        return modelMapper.map(salsetMember, SalsetMemberDTO.class);

    }


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

        List<SalsetMember> salsetMemberList = salsetRepository.findAll();

        log.info("[SalaryService] {}", salsetMemberList);
        log.info(("[SalaryService] selectIncomeTax End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑"));

        return salsetMemberList.stream().map(salsetMember -> modelMapper.map(salsetMember, SalsetMemberDTO.class)).collect(Collectors.toList());

    }


    public Object insertSalset(EmployeeSalarySettingDTO employeeSalarySettingDTO) {
        log.info(("[SalaryService] insertSalset Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));
        log.info(("[SalaryService] employeeSalarySettingDTO : " + employeeSalarySettingDTO));

        int result = 0;

        try {


            EmployeeSalarySetting insertSalset = modelMapper.map(employeeSalarySettingDTO, EmployeeSalarySetting.class);

            employeeSalarySettingRepository.save(insertSalset);

            result = 1;
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        return (result > 0) ? "급여 정보 입력 성공" : "급여 정보 입력 실패";
    }


}
