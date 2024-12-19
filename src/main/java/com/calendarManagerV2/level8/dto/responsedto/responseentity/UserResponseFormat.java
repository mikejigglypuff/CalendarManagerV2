package com.calendarManagerV2.level8.dto.responsedto.responseentity;

import com.calendarManagerV2.level8.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

// 클라이언트에 회원 패스워드를 노출하지 않기 위한 응답 형식
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
