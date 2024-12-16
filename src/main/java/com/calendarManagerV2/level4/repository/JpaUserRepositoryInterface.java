package com.calendarManagerV2.level4.repository;

import com.calendarManagerV2.level4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepositoryInterface extends JpaRepository<User, Long> {
    User findFirstByUserID(long userID);
    User findFirstByEmail(String email);
    User findFirstByEmailAndPassword(String email, String password);
}
