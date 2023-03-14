package com.in4people.bootrestapi.salary.repository;

import com.in4people.bootrestapi.salary.entity.IncomeTax;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<IncomeTax, String> {


//    List<IncomeTax> findAll();



}
