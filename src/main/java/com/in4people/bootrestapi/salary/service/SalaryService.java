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





//    public Object insertSalset(EmpSalSettingDTO empSalSettingDTO) {
//        log.info(("[SalaryService] insertSalset Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));
//        log.info(("[SalaryService] empSalSettingDTO : " + empSalSettingDTO));
//
//        int result = 0;
//
//        try {
//
//            EmployeeSalarySetting employeeSalarySetting = new EmployeeSalarySetting();
//
//            employeeSalarySetting.setSalarySettingCode(empSalSettingDTO.getSalarySettingCode());
//            employeeSalarySetting.setMemCode(empSalSettingDTO.getMemCode());
//            employeeSalarySetting.setBank(empSalSettingDTO.getBank());
//            employeeSalarySetting.setAccountNumber(empSalSettingDTO.getAccountNumber());
//            employeeSalarySetting.setSettingDate(empSalSettingDTO.getSettingDate());
//
//            java.util.Date now = new java.util.Date();
//            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
//            String setDate = sdf.format(now);
//            employeeSalarySetting.setSettingDate(Date.valueOf(setDate));
//
//            salsetRepository.save(employeeSalarySetting);
//
//            result = 1;
//
//        } catch (Exception e) {
//
//            log.info("[employeeSalarySetting] Exception!!");
//        }
//
//            log.info("[SalaryService] insertSalset End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
//            return (result > 0) ? "입력 성공" : "입력 실패";
//    }
}
