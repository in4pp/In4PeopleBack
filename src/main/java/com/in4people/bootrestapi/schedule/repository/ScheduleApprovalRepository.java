package com.in4people.bootrestapi.schedule.repository;


import com.in4people.bootrestapi.approveWork.entity.DocumentApproval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleApprovalRepository extends JpaRepository<DocumentApproval, String> {
    List<DocumentApproval> findByApprovedCodeApprovedCodeAndScheduleNumberIsNotNull(String approvedCode);



}
