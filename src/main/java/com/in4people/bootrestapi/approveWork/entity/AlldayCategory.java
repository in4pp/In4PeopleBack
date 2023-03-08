package com.in4people.bootrestapi.approveWork.entity;

// 휴가 전일/반일 entity

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALLDAY_CATEGORY")
public class AlldayCategory {

    @Id
    @Column(name = "ALLDAY_CODE")
    private String alldayCode;   // 전일 / 반일 코드 PK

    @Column(name = "ALLDAY_NAME")
    private String alldayName;   // 전일 / 반일 이름

    public AlldayCategory() {
    }

    public AlldayCategory(String alldayCode, String alldayName) {
        this.alldayCode = alldayCode;
        this.alldayName = alldayName;
    }

    public String getAlldayCode() {
        return alldayCode;
    }

    public void setAlldayCode(String alldayCode) {
        this.alldayCode = alldayCode;
    }

    public String getAlldayName() {
        return alldayName;
    }

    public void setAlldayName(String alldayName) {
        this.alldayName = alldayName;
    }

    @Override
    public String toString() {
        return "AlldayCategory{" +
                "alldayCode='" + alldayCode + '\'' +
                ", alldayName='" + alldayName + '\'' +
                '}';
    }
}
