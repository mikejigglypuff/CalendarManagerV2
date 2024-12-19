package com.calendarManagerV2.level8.mvc.repository;

import com.calendarManagerV2.level8.entity.Schedule;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Spring Data JPA의 Query Method 기반 Repository
public interface JpaScheduleRepositoryInterface extends JpaRepository<Schedule, Long> {

    Schedule findFirstByScheduleID(long scheduleID);

    List<Schedule> findAllByUser_UserIDOrderByUpdatedAtDesc(long userID);

    List<Schedule> findAllPagingByUser_UserIDOrderByUpdatedAtDesc(long userID, Pageable pageable);

    List<Schedule> findAllBy(Pageable pageable);
}
