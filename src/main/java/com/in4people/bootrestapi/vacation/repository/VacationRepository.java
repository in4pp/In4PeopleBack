package com.in4people.bootrestapi.vacation.repository;

import com.in4people.bootrestapi.vacation.entity.AnnualMake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<AnnualMake, String> {
}
