package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.InsertApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsertApprovalRepository extends JpaRepository<InsertApproval, String> {
}
