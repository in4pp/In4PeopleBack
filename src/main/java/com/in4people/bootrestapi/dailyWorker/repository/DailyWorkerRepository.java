package com.in4people.bootrestapi.dailyWorker.repository;

import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DailyWorkerRepository extends JpaRepository<DailyWorker, Integer> {


    List<DailyWorker> findByworkerNameContaining(String workerName);

    DailyWorker findByWorkerCode(int workerCode);

    List<DailyWorker> findAllByWorkerCode(int workerCode);

}
