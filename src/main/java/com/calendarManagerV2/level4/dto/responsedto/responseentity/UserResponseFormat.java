package com.calendarManagerV2.level4.dto.responsedto.responseentity;

import com.calendarManagerV2.level4.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseFormat {
    private final long userID;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;

    public UserResponseFormat(User user) {
        this.userID = user.getUserID();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
