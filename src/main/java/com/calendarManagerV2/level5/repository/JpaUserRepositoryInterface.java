package com.calendarManagerV2.level5.repository;

import com.calendarManagerV2.level5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepositoryInterface extends JpaRepository<User, Long> {
    User findFirstByUserID(long userID);
    User findFirstByEmail(String email);
    User findFirstByEmailAndPassword(String email, String password);
}
