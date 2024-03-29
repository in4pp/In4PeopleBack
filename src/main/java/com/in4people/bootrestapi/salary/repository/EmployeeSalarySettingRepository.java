package com.in4people.bootrestapi.salary.repository;

import com.in4people.bootrestapi.salary.entity.EmployeeSalarySetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSalarySettingRepository extends JpaRepository<EmployeeSalarySetting, String> {


    EmployeeSalarySetting findByMemCode(String memCode);
}
