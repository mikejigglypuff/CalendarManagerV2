package com.calendarManagerV2.level8.mvc.repository;

import com.calendarManagerV2.level8.entity.Schedule;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaScheduleRepositoryInterface extends JpaRepository<Schedule, Long> {
    Schedule findFirstByUser_UserID(long userID);
    Schedule findFirstByScheduleID(long scheduleID);
    List<Schedule> findAllByUser_UserIDOrderByUpdatedAtDesc(long userID);
    List<Schedule> findAllPagingByUser_UserIDOrderByUpdatedAtDesc(long userID, Pageable pageable);
    List<Schedule> findAllBy(Pageable pageable);
}
