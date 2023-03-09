package com.in4people.bootrestapi.personnel.repository;

import com.in4people.bootrestapi.personnel.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonnelRepository extends JpaRepository<Certificate, String> {
    Certificate findByCerCode(String cerCode);
}
