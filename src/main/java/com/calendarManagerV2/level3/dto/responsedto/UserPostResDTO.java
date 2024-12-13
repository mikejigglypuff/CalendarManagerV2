package com.calendarManagerV2.level3.dto.responsedto;

import com.calendarManagerV2.level3.dto.responsedto.responseentity.UserResponseFormat;
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
