package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.UserEmailValidation;
import com.calendarManagerV2.level8.annotation.UserPasswordValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginReqDTO {
    @NotNull(message = "이메일 값이 포함되어야 합니다.")
    @UserEmailValidation
    @Schema(description = "필수 항목", nullable = true)
    private final String email;

    @UserPasswordValidation
    private final String password;
}
