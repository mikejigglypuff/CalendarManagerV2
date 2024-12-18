package com.calendarManagerV2.level8.mvc.service;

import com.calendarManagerV2.level8.dto.requestdto.*;
import com.calendarManagerV2.level8.dto.responsedto.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level8.dto.responsedto.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.level8.entity.Schedule;
import com.calendarManagerV2.level8.entity.User;
import com.calendarManagerV2.level8.mvc.repository.JpaScheduleRepositoryInterface;
import com.calendarManagerV2.level8.mvc.repository.JpaUserRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
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
    public List<ScheduleResponseFormat> findScheduleByUserID(ScheduleGetReqDTO getDTO, PaginationReqDTO pageDTO) {
        if(pageDTO.isPaging())
            return mapper.mapList(
                scheduleRepository.findAllPagingByUser_UserIDOrderByUpdatedAtDesc (
                    getDTO.getUserID(), PageRequest.of(pageDTO.getOffset(), pageDTO.getSize())
            ));
        return mapper.mapList(scheduleRepository.findAllByUser_UserIDOrderByUpdatedAtDesc(getDTO.getUserID()));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public List<ScheduleResponseFormat> findAllSchedules(PaginationReqDTO pageDTO) {
        if(pageDTO.isPaging())
            return mapper.mapList(scheduleRepository.findAllBy(PageRequest.of(pageDTO.getOffset(), pageDTO.getSize())));
        return mapper.mapList(scheduleRepository.findAll());
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

        return new ScheduleResponseFormat(scheduleRepository.save(schedule));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteSchedule(ScheduleDeleteReqDTO dto, User sessionUser) {
        Schedule schedule = scheduleRepository.findFirstByScheduleID(dto.getScheduleID());

        if(schedule.getUser().equals(sessionUser)) {
            scheduleRepository.delete(schedule);
            return schedule.getTitle() + " 일정을 삭제했습니다.";
        }

        return "일정 삭제 실패";
    }
}
