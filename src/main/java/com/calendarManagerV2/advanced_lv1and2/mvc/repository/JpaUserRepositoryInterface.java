package com.calendarManagerV2.advanced_lv1and2.mvc.repository;

import com.calendarManagerV2.advanced_lv1and2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA의 Query Method 기반 Repository
public interface JpaUserRepositoryInterface extends JpaRepository<User, Long> {
    User findFirstByUserID(long userID);
    User findFirstByEmail(String email);
}
