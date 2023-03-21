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

import javax.persistence.EntityManager;
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
    private final EntityManager em;


    public Object selectSalinfo() {

        log.info(("[SalaryService] selectSalinfo Start ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓"));

        List<SalsetMember> salsetMemberList = salsetRepository.findAll();

        log.info("[SalaryService] {}", salsetMemberList);
        log.info(("[SalaryService] selectSalinfo End ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑"));

        return salsetMemberList.stream().map(salsetMember -> modelMapper.map(salsetMember, SalsetMemberDTO.class)).collect(Collectors.toList());
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

    public Object selectCalculateMonthlyWage() {

        List<SalsetMember> salsetMemberList = salsetRepository.findAll();
        List<SalsetMemberDTO> salsetMemberDTOList = salsetMemberList.stream().map(salsetMember1 -> modelMapper.map(salsetMember1, SalsetMemberDTO.class)).collect(Collectors.toList());

        System.out.println("salsetMemberList = " + salsetMemberList);

        for (SalsetMemberDTO salsetMember : salsetMemberDTOList) {

            for (EmployeeSalarySettingDTO employeeSalarySetting : salsetMember.getEmployeeSalarySettingList()) {
                MonthlyWageDTO monthlyWageDTO = new MonthlyWageDTO();
                monthlyWageDTO.setMonthlyPaycheck(employeeSalarySetting.getBasicMonthlySalary());                        // 월기본급
                monthlyWageDTO.setPaymentDate(employeeSalarySetting.getSettingDate());                                   // 해당 월
                monthlyWageDTO.setBonusSUM(200000);                                                                      // 상여금합계
                monthlyWageDTO.setTotalSum(employeeSalarySetting.getBasicMonthlySalary() + monthlyWageDTO.getBonusSUM());// 총합계
                monthlyWageDTO.setNationalPension(monthlyWageDTO.getTotalSum() * 0.045);                                 // 국민연금공제액
                monthlyWageDTO.setHealthInsurance(monthlyWageDTO.getTotalSum() * 0.035);                                 // 건강보험공제액
                monthlyWageDTO.setEmploymentInsurance(monthlyWageDTO.getTotalSum() * 0.009);                             // 고용보험공제액
                monthlyWageDTO.setIncomeTax1(monthlyWageDTO.getTotalSum() * 0.03);                                       // 소득세공제액
                monthlyWageDTO.setIncomeTax2(monthlyWageDTO.getTotalSum() * 0.003);                                      // 지방소득세공제액

                monthlyWageDTO.setNetSalary(monthlyWageDTO.getTotalSum() - monthlyWageDTO.getNationalPension()
                        - monthlyWageDTO.getHealthInsurance() - monthlyWageDTO.getEmploymentInsurance() - monthlyWageDTO.getIncomeTax1() - monthlyWageDTO.getIncomeTax2());        // 실수령액

                employeeSalarySetting.getMontlyWageList().add(monthlyWageDTO);
            }
        }
        return salsetMemberDTOList;
    }






        public Object insertSalset(EmployeeSalarySettingDTO employeeSalarySettingDTO){
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

