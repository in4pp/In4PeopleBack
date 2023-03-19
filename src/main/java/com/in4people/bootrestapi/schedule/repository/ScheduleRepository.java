package com.in4people.bootrestapi.schedule.repository;

import com.in4people.bootrestapi.schedule.entity.WorkSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<WorkSetting, String> {

    List<WorkSetting> findAll();
}
