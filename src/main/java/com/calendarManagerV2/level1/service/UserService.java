package com.calendarManagerV2.level1.service;

import com.calendarManagerV2.level1.entity.User;
import com.calendarManagerV2.level1.repository.JpaUserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
//@Service
public class UserService {
    private final JpaUserRepositoryInterface repository;

    public User findOneUser(long userID) {
        return repository.findFirstByUserID(userID);
    }
}
