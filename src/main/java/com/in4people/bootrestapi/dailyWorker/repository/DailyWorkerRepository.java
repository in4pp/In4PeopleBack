package com.in4people.bootrestapi.dailyWorker.repository;

import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyWorkerRepository extends JpaRepository<DailyWorker, Integer> {

    DailyWorker findByWorkerCode(int workerCode);





}
