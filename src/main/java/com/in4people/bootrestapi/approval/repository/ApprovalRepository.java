package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.approval.entity.ApprovalMem;
import com.in4people.bootrestapi.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ApprovalRepository extends JpaRepository<Approval, String> {

    @EntityGraph(value = "Approval.fetchAll", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT a FROM Approval a WHERE a.approvalMem.memCode = ?1")
    List<Approval> getApprovalList(String memCode);
//    List<Approval> workDocList(String docType);

    @EntityGraph(value = "Approval.fetchAll", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT a FROM Approval a WHERE a.approvalMem.memCode = ?1")
    Page<Approval> getApprovalList(String memCode, Pageable paging);

    @EntityGraph(value = "Approval.fetchAll", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT a FROM Approval a WHERE a.approvalMem.memCode = :memCode" +
            " AND to_char(a.reportDate, 'YY-MM-DD') BETWEEN :startDate AND :endDate ORDER BY a.reportDate desc ")
    List<Approval> getSearchApproval(String memCode, String startDate, String endDate);

//    @Query("SELECT a FROM Approval a WHERE a.memCode = ?1 ")
//    List<Approval> findByMemCode(String memCode);

}

