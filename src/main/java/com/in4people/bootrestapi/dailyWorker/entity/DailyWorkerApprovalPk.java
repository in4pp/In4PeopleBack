package com.in4peopl.bootrestapi.dailyWorker.entity;

import java.io.Serializable;

public class DailyWorkerApprovalPk implements Serializable {
    private String docCode;
    private String memCode;

    public DailyWorkerApprovalPk() {
    }

    public DailyWorkerApprovalPk(String docCode, String memCode) {
        this.docCode = docCode;
        this.memCode = memCode;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    @Override
    public String toString() {
        return "DailyWorkerApprovalPk{" +
                "docCode='" + docCode + '\'' +
                ", memCode='" + memCode + '\'' +
                '}';
    }

}
