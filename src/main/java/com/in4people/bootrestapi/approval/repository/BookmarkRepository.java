package com.in4people.bootrestapi.approval.repository;

import com.in4people.bootrestapi.approval.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {
    
}
