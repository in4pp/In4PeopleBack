package com.in4people.bootrestapi.workState.repository;

import com.in4people.bootrestapi.workState.entity.AttendRegist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkStateRepository extends JpaRepository<AttendRegist,String> {
}
