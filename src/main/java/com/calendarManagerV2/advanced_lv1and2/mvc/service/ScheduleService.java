package com.calendarManagerV2.advanced_lv1and2.mvc.service;

import com.calendarManagerV2.advanced_lv1and2.dto.request.PaginationReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.ScheduleDeleteReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.ScheduleGetReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.SchedulePatchReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.schedule.SchedulePostReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.mapper.ResponseFormatMapper;
import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.advanced_lv1and2.entity.Schedule;
import com.calendarManagerV2.advanced_lv1and2.entity.User;
import com.calendarManagerV2.advanced_lv1and2.mvc.repository.JpaScheduleRepositoryInterface;
import com.calendarManagerV2.advanced_lv1and2.mvc.repository.JpaUserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final JpaScheduleRepositoryInterface scheduleRepository;
    private final JpaUserRepositoryInterface userRepository;
    private final ResponseFormatMapper<ScheduleResponseFormat, Schedule> mapper;

    @Transactional(rollbackFor = {DataAccessException.class})
    public List<ScheduleResponseFormat> findScheduleByUserID(ScheduleGetReqDTO getDTO, PaginationReqDTO pageDTO) {
        // 요청이 페이징을 요구했는지 확인해 각각 다른 방식의 쿼리를 실행하도록 함
        if (pageDTO.isPaging())
            return mapper.mapList(
                scheduleRepository.findAllPagingByUser_UserIDOrderByUpdatedAtDesc(
                    getDTO.getUserID(), PageRequest.of(pageDTO.getOffset(), pageDTO.getSize())
                ));
        return mapper.mapList(scheduleRepository.findAllByUser_UserIDOrderByUpdatedAtDesc(getDTO.getUserID()));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public List<ScheduleResponseFormat> findAllSchedules(PaginationReqDTO pageDTO) {
        // 요청이 페이징을 요구했는지 확인해 각각 다른 방식의 쿼리를 실행하도록 함
        if (pageDTO.isPaging())
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

        // 작성자와 수정 요청을 보낸 회원이 동일한지 확인
        if (sessionUser.equals(schedule.getUser())) schedule.setScheduleByPatchDTO(dto);
        return new ScheduleResponseFormat(scheduleRepository.save(schedule));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteSchedule(ScheduleDeleteReqDTO dto, User sessionUser) {
        Schedule schedule = scheduleRepository.findFirstByScheduleID(dto.getScheduleID());

        // 작성자와 삭제 요청을 보낸 회원이 동일한지 확인
        if (schedule.getUser().equals(sessionUser)) {
            scheduleRepository.delete(schedule);
            return schedule.getTitle() + " 일정을 삭제했습니다.";
        }

        return "일정 삭제 실패";
    }
}
