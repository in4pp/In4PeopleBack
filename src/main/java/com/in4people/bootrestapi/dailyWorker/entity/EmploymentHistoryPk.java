package com.in4people.bootrestapi.dailyWorker.entity;

import java.io.Serializable;

public class EmploymentHistoryPk implements Serializable {

        private int workCode;        //근무코드

        private int workerCode;      //일용직사원 코드

        public EmploymentHistoryPk() {
        }

        public EmploymentHistoryPk(int workCode, int workerCode) {
            this.workCode = workCode;
            this.workerCode = workerCode;
        }

        public int getWorkCode() {
            return workCode;
        }

        public void setWorkCode(int workCode) {
            this.workCode = workCode;
        }

        public int getWorkerCode() {
            return workerCode;
        }

        public void setWorkerCode(int workerCode) {
            this.workerCode = workerCode;
        }

        @Override
        public String toString() {
            return "EmploymentHistoryPk{" +
                    "workCode=" + workCode +
                    ", workerCode=" + workerCode +
                    '}';
        }

}
