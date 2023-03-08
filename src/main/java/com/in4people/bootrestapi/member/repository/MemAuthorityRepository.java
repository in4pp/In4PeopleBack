package com.in4people.bootrestapi.member.repository;

import com.in4people.bootrestapi.member.entity.MemAuthority;
import com.in4people.bootrestapi.member.entity.MemAuthorityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemAuthorityRepository extends JpaRepository<MemAuthority, MemAuthorityPK> {
}
