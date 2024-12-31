package com.calendarManagerV2.advanced_lv1and2.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginReqDTO {
    @Schema(description = "필수 항목")
    @NotNull(message = "이메일이 포함되어야 합니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private final String email;

    @NotNull(message = "패스워드가 포함되어야 합니다.")
    @Size(max = 15, message = "비밀번호는 15자 이하여야 합니다.")
    private final String password;

}
