package com.in4people.bootrestapi.salary.repository;

import com.in4people.bootrestapi.salary.entity.MonthlyWage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyWageRepository extends JpaRepository<MonthlyWage, String> {

}
