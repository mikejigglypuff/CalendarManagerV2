package com.calendarManagerV2.level1.repository;

import com.calendarManagerV2.level1.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaScheduleRepositoryInterface extends JpaRepository<Schedule, Long> {
    public List<Schedule> findByUser_UserID(long userID);
}
