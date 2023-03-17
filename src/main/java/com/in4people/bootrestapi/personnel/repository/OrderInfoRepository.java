package com.in4people.bootrestapi.personnel.repository;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.personnel.entity.PerOrderApp;
import com.in4people.bootrestapi.personnel.entity.PersonnelApproval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderInfoRepository extends JpaRepository <PersonnelApproval, String> {

//    @Query(value = "select DISTINCT c from PerOrderApp c left join fetch c.")
    Page<PersonnelApproval> findByDocTypeAndIsApproved(String docType, String isApproved, Pageable paging);

    List<PersonnelApproval> findByDocTypeAndIsApproved(String docType, String isApproved);
}
