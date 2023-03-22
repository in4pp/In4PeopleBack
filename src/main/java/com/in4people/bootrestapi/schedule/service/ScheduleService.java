package com.in4people.bootrestapi.schedule.service;

import com.in4people.bootrestapi.approveWork.dto.DocumentApprovalDTO;
import com.in4people.bootrestapi.approveWork.entity.DocumentApproval;

import com.in4people.bootrestapi.approveWork.repository.ApprovedCategoryRepository;

import com.in4people.bootrestapi.schedule.dto.WorkScheduleDTO;
import com.in4people.bootrestapi.schedule.dto.WorkSettingUpDTO;
import com.in4people.bootrestapi.schedule.entity.WorkSchedule;
import com.in4people.bootrestapi.schedule.entity.WorkSetting;


import com.in4people.bootrestapi.approveWork.entity.ApprovedCategory;

import com.in4people.bootrestapi.schedule.entity.WorktypeCategory;
import com.in4people.bootrestapi.schedule.repository.AppWorkScheduleRepository;
import com.in4people.bootrestapi.schedule.repository.ScheduleApprovalRepository;
import com.in4people.bootrestapi.schedule.repository.ScheduleDetailRepository;
import com.in4people.bootrestapi.schedule.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ScheduleService {


    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    private final ScheduleRepository scheduleRepository;

    private final ScheduleApprovalRepository scheduleApprovalRepository;

    private final ApprovedCategoryRepository approvedCategoryRepository;

    private final AppWorkScheduleRepository appWorkScheduleRepository;

    private final ScheduleDetailRepository scheduleDetailRepository;

    private final ModelMapper modelMapper;



    // 근무설정 정보 조회
    public Object selectWorkSetting() {

        log.info("ScheduleService selectWorkSetting Start =============");

        List<WorkSetting> workset = scheduleRepository.findAll();

        log.info("[SettingService] {}" , workset);
        log.info("[SettingService] selectWorkSetting End ======");


        return workset.stream().map(work -> modelMapper.map(work, WorkSetting.class)).collect(Collectors.toList());

    }

    // 근무설정 정보 부분 Or ALL update
    @Transactional
    public Object updateWorkSetting(WorkSettingUpDTO workSettingDTO) {

        log.info("[ScheduleService] updateWorkSetting Start ==============");

        int result = 1;

        try {
            WorkSetting workSet = (scheduleRepository.findAll()).get(0);
            log.info("[WorkSetting update] workSet:" + workSet);


            if (workSettingDTO.getBasicworkTime1() != null) {

                String basictime = workSettingDTO.getBasicworkTime1() + " - "  + workSettingDTO.getBasicworkTime2();
                log.info("[WorkSetting update] basictime:" + basictime);
                workSet.setBasicworkTime(basictime);
            }

            if (workSettingDTO.getBasicrestTime1() != null) {

                String resttime = workSettingDTO.getBasicrestTime1()+ " - "  + workSettingDTO.getBasicrestTime2();
                log.info("[WorkSetting update] resttime:" + resttime);
                workSet.setBasicrestTime(resttime);
            }
            if (workSettingDTO.getStarttimeAvailwork1() != null) {

                String starttime = workSettingDTO.getStarttimeAvailwork1()+ " - "  + workSettingDTO.getStarttimeAvailwork2();
                log.info("[WorkSetting update] starttime:" + starttime);
                workSet.setStarttimeAvailwork(starttime);
            }
            if (workSettingDTO.getEndtimeAvailwork1() != null) {

                String endtime = workSettingDTO.getEndtimeAvailwork1()+ " - "  + workSettingDTO.getEndtimeAvailwork2();
                log.info("[WorkSetting update] endtime:" + endtime);
                workSet.setEndtimeAvailwork(endtime);
            }
            if (workSettingDTO.getFixedWorkingHours() != 0) {

                log.info("[WorkSetting update] workSettingDTO.getFixedWorkingHours():" + workSettingDTO.getFixedWorkingHours());
                workSet.setFixedWorkingHours(workSettingDTO.getFixedWorkingHours());
            }
            if (workSettingDTO.getMaximumOvertimeHours() != 0) {

                log.info("[WorkSetting update] workSettingDTO.getMaximumOvertimeHours():" + workSettingDTO.getMaximumOvertimeHours());
                workSet.setMaximumOvertimeHours((workSettingDTO.getMaximumOvertimeHours()));
            }
            if (workSettingDTO.getWorktypeCode() != null) {

                WorktypeCategory sam1 = new WorktypeCategory();
                sam1.setWorktypeCode(workSettingDTO.getWorktypeCode());
                log.info("[WorkSetting update] sam1:" + sam1);

                workSet.setWorktypeCode(sam1);


                log.info("[WorkSetting update] workSet22222:" + workSet);
            }
            if (workSettingDTO.getDay1() != 0 || workSettingDTO.getDay2() != 0 || workSettingDTO.getDay3() != 0 || workSettingDTO.getDay4() != 0
                    || workSettingDTO.getDay5() != 0  || workSettingDTO.getDay6() != 0  || workSettingDTO.getDay7() != 0) {

                log.info("[WorkSetting update] workSettingDTO.getDay1():" + workSettingDTO.getDay1());
                String dayRule = Integer.toString(workSettingDTO.getDay1()) + Integer.toString(workSettingDTO.getDay2()) + Integer.toString(workSettingDTO.getDay3())
                        + Integer.toString(workSettingDTO.getDay4()) + Integer.toString(workSettingDTO.getDay5()) + Integer.toString(workSettingDTO.getDay6())
                        + Integer.toString(workSettingDTO.getDay7());
                log.info("[WorkSetting update] dayRule:" + dayRule);

                int dayRule1 = Integer.valueOf(dayRule);

                log.info("[WorkSetting update] dayRule:" + dayRule1);

                workSet.setWorkdayRule((dayRule1));
            }

            result =1;

        } catch (Exception e){

            log.info("[WorkSetting update] Exception!");
        }

        log.info("[ScheduleService] updateWorkSetting End ==============");

        return (result > 0 ) ? "기본 근무 설정 수정 성공 " : "기본 근무 설정 수정 실패";

    }

    // 신청한 스케줄 정보만 조회
    public Object selectScheduleApprove() {

        log.info("ScheduleService selectScheduleApprove Start =============");

        try {

            // 스케줄 번호가 "SCHEDULE" 이 포함되면서  결제상태코드가 신청상태인 리스트만 불러오기 DocumentApproval기준

            // ApprovedCategory에서 "신청"상태인 컬럼 가져오기
            ApprovedCategory approvedCategory = approvedCategoryRepository.findByApprovedCode("apporved1");
            if (approvedCategory == null) {
                // 예외 처리

                throw new RuntimeException("approvedCategory가 null입니다.");
            }
            log.info("[SettingService] {}", approvedCategory);





            // 전자결제에서 스케줄신청 is not null + "apporved1"인 리스트만 불러오기
            List<DocumentApproval> approvalSchedule = scheduleApprovalRepository.
                        findByApprovedCodeApprovedCodeAndScheduleNumberIsNotNull
                                (approvedCategory.getApprovedCode());

            if (approvalSchedule == null) {
                // 예외 처리

                throw new RuntimeException("approvalSchedule null입니다.");

            }


                log.info("[SettingService] {}", approvalSchedule);







            return approvalSchedule.stream().map(schedule -> modelMapper.map(schedule, DocumentApproval.class)).collect(Collectors.toList());

        } catch (Exception e){

            log.info("[WorkSetting update] Exception!");

        }


        log.info("[SettingService] selectScheduleApprove End ======");



        return  "스케줄관리 조회 실패";
    }


    // 신청한 스케줄의 날짜별 근무시간 + 휴게시간 조회
    public Object selectScheduleApproveDay() {

        log.info("ScheduleService selectScheduleApproveDay Start =============");

        try {


            // 근무스케줄에서  "apporved1"+ 모든 리스트 불러오기
            List<WorkSchedule> workSchedules = scheduleDetailRepository.
                    findByScheduleNumberDocumentNumberApprovedCodeApprovedCode("apporved1");
            if (workSchedules == null) {
                // 예외 처리

                throw new RuntimeException("workSchedules null입니다.");

            }


            log.info("[SettingService] {}", workSchedules);



            return workSchedules.stream().map(schedule -> modelMapper.map(schedule, WorkScheduleDTO.class)).collect(Collectors.toList());

        } catch (Exception e){

            log.info("[SettingService] Exception!");

        }


        log.info("[SettingService] selectScheduleApproveDay End ======");



        return  "스케줄관리 조회 실패";
    }







}
