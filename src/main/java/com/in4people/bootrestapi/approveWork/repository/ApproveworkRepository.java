package com.in4people.bootrestapi.approveWork.repository;

import com.in4people.bootrestapi.approveWork.entity.WorkSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApproveworkRepository extends JpaRepository<WorkSetting, String> {

    WorkSetting findByWorkSettingNumber(String workSettingNumber);
}
