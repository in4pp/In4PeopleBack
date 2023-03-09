package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApprovalRepository extends JpaRepository<Approval, String> {
    List<Approval> findByMemCode(Member member);

//    @Query("SELECT a FROM Approval a WHERE a.memCode = ?1 ")
//    List<Approval> findByMemCode(String memCode);
}

