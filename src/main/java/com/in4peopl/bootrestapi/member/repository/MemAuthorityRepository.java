package com.in4peopl.bootrestapi.member.repository;

import com.in4peopl.bootrestapi.member.entity.MemAuthority;
import com.in4peopl.bootrestapi.member.entity.MemAuthorityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemAuthorityRepository extends JpaRepository<MemAuthority, MemAuthorityPK> {
}
