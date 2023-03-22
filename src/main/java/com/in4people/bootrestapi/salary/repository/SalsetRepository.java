package com.in4people.bootrestapi.salary.repository;

import com.in4people.bootrestapi.salary.entity.EmployeeSalarySetting;
import com.in4people.bootrestapi.salary.entity.SalsetMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalsetRepository extends JpaRepository<SalsetMember, String> {


    SalsetMember findByMemCode(String memCode);

//    SalsetMember findByDepartmentCode(String dep_01);
}
