package com.in4people.bootrestapi.schedule.service;

import com.in4people.bootrestapi.schedule.dto.WorkSettingDTO;
import com.in4people.bootrestapi.schedule.dto.WorkSettingUpDTO;
import com.in4people.bootrestapi.schedule.entity.WorkSetting;
import com.in4people.bootrestapi.schedule.entity.WorktypeCategory;
import com.in4people.bootrestapi.schedule.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Service
@AllArgsConstructor
public class ScheduleService {


    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    private final ScheduleRepository scheduleRepository;

    private final ModelMapper modelMapper;


    public Object selectWorkSetting() {

        log.info("ScheduleService selectWorkSetting Start =============");

        List<WorkSetting> workset = scheduleRepository.findAll();

        log.info("[SettingService] {}" , workset);
        log.info("[SettingService] selectWorkSetting End ======");


        return workset.stream().map(work -> modelMapper.map(work, WorkSetting.class)).collect(Collectors.toList());
                //modelMapper.map(workset, WorkSettingDTO.class);
    }

    @Transactional
    public Object updateWorkSetting(WorkSettingUpDTO workSettingDTO) {

        log.info("[ScheduleService] updateWorkSetting Start ==============");

        int result = 1;

        try {
            WorkSetting workSet = (scheduleRepository.findAll()).get(0);
            log.info("[WorkSetting update] workSet:" + workSet);



//            String dayRule = workSettingDTO.getDay1() + workSettingDTO.getDay2() + workSettingDTO.getDay3()
//                             + workSettingDTO.getDay4() + workSettingDTO.getDay5() + workSettingDTO.getDay6()
//                             + workSettingDTO.getDay7();
//
//            log.info("[WorkSetting update] dayRule:" + dayRule);
//
//            int dayRule1 = parseInt(dayRule);
//
//            log.info("[WorkSetting update] dayRule:" + dayRule1);
//
//            workSet.setWorkdayRule((dayRule1));




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
}
