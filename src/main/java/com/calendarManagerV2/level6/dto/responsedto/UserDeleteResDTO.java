package com.calendarManagerV2.level6.dto.responsedto;

import lombok.Getter;

@Getter
public class UserDeleteResDTO {
    private final String message;

    public UserDeleteResDTO(String username) {
        this.message = username + "님의 탈퇴가 완료되었습니다.";
    }
}
