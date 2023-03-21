package com.in4people.bootrestapi.schedule.repository;

import com.in4people.bootrestapi.approveWork.entity.ApprovedCategory;
import com.in4people.bootrestapi.schedule.entity.ApplicationWorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppWorkScheduleRepository extends JpaRepository<ApplicationWorkSchedule, String> {



    List<ApplicationWorkSchedule> findAll();
}
