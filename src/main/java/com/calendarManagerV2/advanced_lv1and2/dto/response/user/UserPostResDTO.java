package com.calendarManagerV2.advanced_lv1and2.dto.response.user;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.UserResponseFormat;
import lombok.Getter;

@Getter
public class UserPostResDTO {
    private final String message;
    private final UserResponseFormat userFormat;

    public UserPostResDTO(UserResponseFormat userFormat) {
        this.userFormat = userFormat;
        this.message = "환영합니다, " + userFormat.getUsername() + ".";
    }
}
