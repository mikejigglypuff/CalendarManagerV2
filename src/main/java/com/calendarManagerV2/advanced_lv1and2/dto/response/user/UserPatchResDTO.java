package com.calendarManagerV2.advanced_lv1and2.dto.response.user;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.UserResponseFormat;
import lombok.Getter;

@Getter
public class UserPatchResDTO {
    private final String message;
    private final UserResponseFormat userFormat;

    public UserPatchResDTO(UserResponseFormat userFormat) {
        this.userFormat = userFormat;
        this.message = userFormat.getUsername() + "님의 회원정보가 수정되었습니다.";
    }
}
