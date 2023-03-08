package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.approval.entity.ApprovalPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepository extends JpaRepository<Approval, ApprovalPK> {}

