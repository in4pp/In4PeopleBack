package com.in4people.bootrestapi.approveWork.repository;

import com.in4people.bootrestapi.approveWork.entity.DocumentApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApproveworkRepository extends JpaRepository<DocumentApproval, String> {


    DocumentApproval findByDocumentNumber(String documentNumber);
}
