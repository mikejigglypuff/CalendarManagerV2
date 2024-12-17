package com.calendarManagerV2.level7.dto.requestdto;

import com.calendarManagerV2.level7.annotation.UserEmailValidation;
import com.calendarManagerV2.level7.annotation.UserPasswordValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserPostReqDTO {
    @NotNull(message = "사용자 이름이 포함되어야 합니다.")
    private final String username;
    @NotNull(message = "이메일 값이 포함되어야 합니다.")
    @UserEmailValidation
    private final String email;
    @UserPasswordValidation
    private final String password;
}
