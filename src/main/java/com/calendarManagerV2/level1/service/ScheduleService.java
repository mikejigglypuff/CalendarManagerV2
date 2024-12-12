package com.calendarManagerV2.level1.service;

import com.calendarManagerV2.level1.dto.requestdto.ScheduleGetReqDTO;
import com.calendarManagerV2.level1.entity.Schedule;
import com.calendarManagerV2.level1.repository.JpaScheduleRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private JpaScheduleRepositoryInterface repository;

    @Autowired
    public ScheduleService(JpaScheduleRepositoryInterface repository) {
        this.repository = repository;
    }

    public List<Schedule> findSchedulesByUserID(ScheduleGetReqDTO dto) {
        return repository.findByUser_UserID(dto.getUserID());
    }
}
