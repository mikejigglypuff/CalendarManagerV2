package com.calendarManagerV2.level4.dto.responsedto;

import lombok.Getter;

@Getter
public class LoginResDTO {
    private final String message;

    public LoginResDTO(String message) {
        this.message = message + "님, 환영합니다.";
    }
}
