package com.in4people.bootrestapi.schedule.repository;

import com.in4people.bootrestapi.schedule.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleDetailRepository extends JpaRepository<WorkSchedule, String> {



    List<WorkSchedule> findByScheduleNumberDocumentNumberApprovedCodeApprovedCode(String apporved1);
}
