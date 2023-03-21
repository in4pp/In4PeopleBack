package com.in4people.bootrestapi.approveWork.repository;


import com.in4people.bootrestapi.approveWork.entity.ApprovedCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedCategoryRepository extends JpaRepository<ApprovedCategory, String> {
    ApprovedCategory findByApprovedCode(String apporved1);
}
