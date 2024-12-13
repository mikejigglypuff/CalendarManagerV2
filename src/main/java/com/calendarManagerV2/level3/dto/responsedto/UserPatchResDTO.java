package com.calendarManagerV2.level3.dto.responsedto;

import com.calendarManagerV2.level3.dto.responsedto.responseentity.UserResponseFormat;

public class UserPatchResDTO {
    private final String message;
    private final UserResponseFormat userFormat;

    public UserPatchResDTO(UserResponseFormat userFormat) {
        this.userFormat = userFormat;
        this.message = userFormat.getUsername() + "님의 회원정보가 수정되었습니다.";
    }
}
