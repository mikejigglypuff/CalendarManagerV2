package com.calendarManagerV2.level5.dto.responsedto;

import lombok.Getter;

@Getter
public class LoginResDTO {
    private final String message;

    public LoginResDTO(String message) {
        this.message = message + "님, 환영합니다.";
    }
}
