package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.DocAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocAttachmentRepository extends JpaRepository<DocAttachment, Integer> {
}
