package com.in4people.bootrestapi.salary.service;

import com.in4people.bootrestapi.salary.dto.*;
import com.in4people.bootrestapi.salary.entity.*;
import com.in4people.bootrestapi.salary.repository.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.TypeResolvingList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private final EmployeeSalarySettingHourlyWageRepository employeeSalarySettingHourlyWageRepository;
    private final MonthlyWageRepository monthlyWageRepository;


    public Object selectMonthlyWage(String memCode) {

        log.info(("[SalaryService] selectMonthlyWage Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));

//        SalsetMember salsetMember = salsetRepository.findByMemCode(memCode);

//        MonthlyWage monthlyWage = monthlyWageRepository.findByMemCode(memCode);

        EmployeeSalarySetting employeeSalarySetting = employeeSalarySettingRepository.findByMemCode(memCode);



//        int wage = employeeSalarySetting.getBasicMonthlySalary();
//
//        System.out.println("wage = " + wage);




//        for (int i = 0; i < monthlyWageList.size(); i++ ){
//            employeeSalarySetting.getMontlyWageList().get(1).setMonthlyPaycheck(wage);
//            employeeSalarySetting.getMontlyWageList().get(1).setTotalSum(wage + 200000);
//            employeeSalarySetting.getMontlyWageList().get(1).setTotalSum(wage + 200000);


//        }
//        wage =



        log.info("[SalaryService] {}", employeeSalarySetting);
        log.info("[SalaryService] selectMonthlyWage End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
//
        return modelMapper.map(employeeSalarySetting, EmployeeSalarySettingDTO.class);
    }



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

        List<SalsetMember> salsetMemberList = salsetRepository.findAll();


        System.out.println("salsetMemberList = " + salsetMemberList);

        List<MonthlyWageDTO> monthlyWageDTOList = new ArrayList<>();

        for(SalsetMember salsetMember : salsetMemberList) {

            for(EmployeeSalarySetting employeeSalarySetting : salsetMember.getEmployeeSalarySettingList()) {
                MonthlyWageDTO monthlyWageDTO = new MonthlyWageDTO();
                monthlyWageDTO.setMonthlyPaycheck(employeeSalarySetting.getBasicMonthlySalary() /2);

                monthlyWageDTOList.add(monthlyWageDTO);
            }
        }
        System.out.println("monthlyWageDTOList = " + monthlyWageDTOList);

        return monthlyWageDTOList;

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
