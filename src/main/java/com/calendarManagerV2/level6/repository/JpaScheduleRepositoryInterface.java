package com.calendarManagerV2.level6.repository;

import com.calendarManagerV2.level6.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaScheduleRepositoryInterface extends JpaRepository<Schedule, Long> {
    Schedule findFirstByUser_UserID(long userID);
    Schedule findFirstByScheduleID(long scheduleID);
}
