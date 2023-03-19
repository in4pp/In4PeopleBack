package com.in4people.bootrestapi.personnel.repository;

import com.in4people.bootrestapi.personnel.entity.PersonnelMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerMemberRepository extends JpaRepository<PersonnelMember, String> {

    List<PersonnelMember> findByIsWorking(char isWorking);

    Page<PersonnelMember> findByIsWorking(char isWorking, Pageable paging);

}
