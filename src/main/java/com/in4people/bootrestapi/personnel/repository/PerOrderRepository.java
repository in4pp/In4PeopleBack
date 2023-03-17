package com.in4people.bootrestapi.personnel.repository;

import com.in4people.bootrestapi.personnel.entity.PerOrderApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerOrderRepository extends JpaRepository<PerOrderApp, Long> {
}
