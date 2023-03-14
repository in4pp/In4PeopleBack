package com.in4people.bootrestapi.schedule.entity;

import com.in4people.bootrestapi.schedule.entity.ApplicationWorkSchedule;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

// 근무 스케줄 entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "WORK_SCHEDULE")
public class WorkSchedule {

    @Id
    @Column(name = "WORK_DATE")
    private Date workDate;           // 근무 날짜 PK

    @ManyToOne
    @JoinColumn(name = "SCHEDULE_NUMBER")
    private ApplicationWorkSchedule scheduleNumber;   // 스케줄 번호 FK

    @Column(name = "WORK_STARTTIME")
    private String workStarttime;    // 근무 시작 시간

    @Column(name = "WORK_ENDTIME")
    private String workEndtime;      // 근무 종료 시간

    @Column(name = "REST_STARTTIME")
    private String restStarttime;    // 휴게 시작 시간

    @Column(name = "REST_ENDTIME")
    private String restEndtime;      // 휴게 종료 시간
}
