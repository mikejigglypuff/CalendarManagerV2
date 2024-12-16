package com.calendarManagerV2.level5.service;

import com.calendarManagerV2.level5.dto.requestdto.ScheduleDeleteReqDTO;
import com.calendarManagerV2.level5.dto.requestdto.ScheduleGetReqDTO;
import com.calendarManagerV2.level5.dto.requestdto.SchedulePatchReqDTO;
import com.calendarManagerV2.level5.dto.requestdto.SchedulePostReqDTO;
import com.calendarManagerV2.level5.dto.responsedto.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.level5.entity.Schedule;
import com.calendarManagerV2.level5.entity.User;
import com.calendarManagerV2.level5.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level5.repository.JpaScheduleRepositoryInterface;
import com.calendarManagerV2.level5.repository.JpaUserRepositoryInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
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

    @Transactional(rollbackFor = {DataAccessException.class})
    public ScheduleResponseFormat findScheduleByUserID(ScheduleGetReqDTO dto) {
        return new ScheduleResponseFormat(scheduleRepository.findFirstByUser_UserID(dto.getUserID()));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public List<ScheduleResponseFormat> findAllSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        log.info(String.valueOf(schedules.isEmpty()));
        return mapper.mapList(schedules);
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public ScheduleResponseFormat addSchedule(SchedulePostReqDTO dto) {
        Schedule schedule = new Schedule(dto);
        schedule.setUser(userRepository.findFirstByUserID(dto.getUserID()));
        return new ScheduleResponseFormat(scheduleRepository.save(schedule));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public ScheduleResponseFormat updateSchedule(SchedulePatchReqDTO dto, User sessionUser) {
        Schedule schedule = scheduleRepository.findFirstByScheduleID(dto.getScheduleID());

        if(sessionUser.equals(schedule.getUser())) {
            String title = dto.getTitle();
            String content = dto.getContent();
            if (title != null) schedule.setTitle(title);
            if (content != null) schedule.setContent(content);
        }

        // 패스워드 불일치 시 예외를 던지는 방식으로 수정할 것
        return new ScheduleResponseFormat(scheduleRepository.save(schedule));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteSchedule(ScheduleDeleteReqDTO dto, User sessionUser) {
        Schedule schedule = scheduleRepository.findFirstByScheduleID(dto.getScheduleID());

        if(schedule.getUser().equals(sessionUser)) {
            scheduleRepository.delete(schedule);
            return schedule.getTitle();
        }

        return "일정 삭제 실패";
    }
}
