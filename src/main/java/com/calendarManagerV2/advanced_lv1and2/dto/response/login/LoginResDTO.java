package com.calendarManagerV2.advanced_lv1and2.dto.response.login;

import lombok.Getter;

@Getter
public class LoginResDTO {
    private final String message;

    public LoginResDTO(String message) {
        this.message = message + "님, 환영합니다.";
    }
}
