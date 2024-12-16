/*
package com.calendarManagerV2.level3.service;

import com.calendarManagerV2.level3.dto.requestdto.ScheduleDeleteReqDTO;
import com.calendarManagerV2.level3.dto.requestdto.ScheduleGetReqDTO;
import com.calendarManagerV2.level3.dto.requestdto.SchedulePatchReqDTO;
import com.calendarManagerV2.level3.dto.requestdto.SchedulePostReqDTO;
import com.calendarManagerV2.level3.dto.responsedto.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.level3.entity.Schedule;
import com.calendarManagerV2.level3.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level3.repository.JpaScheduleRepositoryInterface;
import com.calendarManagerV2.level3.repository.JpaUserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final JpaScheduleRepositoryInterface scheduleRepository;
    private final JpaUserRepositoryInterface userRepository;
    private final ResponseFormatMapper<ScheduleResponseFormat, Schedule> mapper;

    @Autowired
    public ScheduleService(
        JpaScheduleRepositoryInterface scheduleRepository,
        JpaUserRepositoryInterface userRepository,
        @Qualifier("scheduleMapper") ResponseFormatMapper<ScheduleResponseFormat, Schedule> mapper
    ) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ScheduleResponseFormat findScheduleByUserID(ScheduleGetReqDTO dto) {
        return new ScheduleResponseFormat(scheduleRepository.findFirstByUser_UserID(dto.getUserID()));
    }

    public List<ScheduleResponseFormat> findAllSchedules() {
        return mapper.mapList(scheduleRepository.findAll());
    }

    public ScheduleResponseFormat addSchedule(SchedulePostReqDTO dto) {
        Schedule schedule = new Schedule(dto);
        schedule.setUser(userRepository.findFirstByUserID(dto.getUserID()));
        return new ScheduleResponseFormat(scheduleRepository.save(schedule));
    }

    public ScheduleResponseFormat updateSchedule(SchedulePatchReqDTO dto) {
        Schedule schedule = scheduleRepository.findFirstByScheduleID(dto.getScheduleID());

        if(schedule.getUser().getPassword().equals(dto.getPassword())) {
            String title = dto.getTitle();
            String content = dto.getContent();
            if (title != null) schedule.setTitle(title);
            if (content != null) schedule.setContent(content);
        }

        // 패스워드 불일치 시 예외를 던지는 방식으로 수정할 것
        return new ScheduleResponseFormat(scheduleRepository.save(schedule));
    }

    public String deleteSchedule(ScheduleDeleteReqDTO dto) {
        Schedule schedule = scheduleRepository.findFirstByScheduleID(dto.getScheduleID());

        if(schedule.getUser().getPassword().equals(dto.getPassword())) {
            scheduleRepository.delete(schedule);
            return schedule.getTitle();
        }

        return "일정 삭제 실패";
    }
}

 */
