package com.in4people.bootrestapi.dailyWorker.repository;

import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DailyWorkerRepository extends JpaRepository<DailyWorker, Integer> {


//    List<DailyWorker> findByWorkerName(String workerName);

    List<DailyWorker> findAll();

    List<DailyWorker> findByworkerNameContaining(String workerName);
}
