package com.in4people.bootrestapi.member.repository;


import com.in4people.bootrestapi.approval.entity.ApprovalMem;
import com.in4people.bootrestapi.member.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByMemCode(String memCode);

    @EntityGraph(value = "ApprovalMem.fetchAll", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT m FROM ApprovalMem m WHERE m.memName LIKE concat('%', concat(:inputValue,'%'))")
    List<ApprovalMem> getSearchInfoByName(String inputValue);

    @EntityGraph(value = "ApprovalMem.fetchAll", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT DISTINCT m FROM ApprovalMem m WHERE m.positionCode.positionName LIKE concat('%', concat(:inputValue,'%'))")
    List<ApprovalMem> getSearchInfoByPosition(String inputValue);
}
