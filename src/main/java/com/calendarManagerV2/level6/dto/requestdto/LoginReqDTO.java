package com.calendarManagerV2.level6.dto.requestdto;

import com.calendarManagerV2.level6.annotation.UserEmailValidation;
import com.calendarManagerV2.level6.annotation.UserPasswordValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginReqDTO {
    @NotNull(message = "이메일 값이 포함되어야 합니다.")
    @UserEmailValidation
    private final String email;

    @UserPasswordValidation
    private final String password;
}
