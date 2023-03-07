package com.in4people.bootrestapi.member.repository;


import com.in4people.bootrestapi.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByMemCode(String memCode);
}
