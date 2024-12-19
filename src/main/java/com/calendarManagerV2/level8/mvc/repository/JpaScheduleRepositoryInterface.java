package com.calendarManagerV2.level8.mvc.repository;

import com.calendarManagerV2.level8.entity.Schedule;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Spring Data JPA의 Query Method 기반 Repository
public interface JpaScheduleRepositoryInterface extends JpaRepository<Schedule, Long> {
    // 1 + N 방지
    @EntityGraph(attributePaths = {"user"})
    Schedule findFirstByScheduleID(long scheduleID);

    @EntityGraph(attributePaths = {"user"})
    List<Schedule> findAllByUser_UserIDOrderByUpdatedAtDesc(long userID);

    @EntityGraph(attributePaths = {"user"})
    List<Schedule> findAllPagingByUser_UserIDOrderByUpdatedAtDesc(long userID, Pageable pageable);

    @EntityGraph(attributePaths = {"user"})
    List<Schedule> findAllBy(Pageable pageable);

    // 기본적으로 생성되는 findAll에 EntityGraph 적용
    @Override
    @EntityGraph(attributePaths = {"user"})
    List<Schedule> findAll();
}
