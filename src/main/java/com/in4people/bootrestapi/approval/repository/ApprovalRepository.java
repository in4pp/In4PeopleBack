package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.approval.entity.ApprovalMem;
import com.in4people.bootrestapi.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApprovalRepository extends JpaRepository<Approval, String> {
    @Query("SELECT DISTINCT a FROM Approval a JOIN FETCH a.approvalMem m WHERE m.memCode = ?1")
    List<Approval> getApprovalList(String memCode);
//    List<Approval> workDocList(String docType);

    List<Approval> findAllByDocType(String docType);

//    @Query("SELECT a FROM Approval a WHERE a.memCode = ?1 ")
//    List<Approval> findByMemCode(String memCode);
}

