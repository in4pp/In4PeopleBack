package com.in4people.bootrestapi.dailyWorker.repository;

import com.in4people.bootrestapi.dailyWorker.entity.DailyWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DailyWorkerRepository extends JpaRepository<DailyWorker, Integer> {

    DailyWorker findByWorkerCode(int workerCode);


    @Query("SELECT MAX(a.workerCode) FROM DailyWorker a")
    int maxMemberCode();

}
