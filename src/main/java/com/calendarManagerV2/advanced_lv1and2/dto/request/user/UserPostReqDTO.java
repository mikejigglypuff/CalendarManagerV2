package com.calendarManagerV2.advanced_lv1and2.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserPostReqDTO {
    @Schema(description = "필수 항목")
    @NotNull(message = "회원 이름이 포함되어야 합니다.")
    @Size(max = 10, message = "이름은 10자 이하여야 합니다.")
    private final String username;

    @Schema(description = "필수 항목")
    @NotNull(message = "이메일이 포함되어야 합니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private final String email;

    @Schema(description = "필수 항목")
    @NotNull(message = "패스워드가 포함되어야 합니다.")
    @Size(max = 15, message = "패스워드는 15자 이하여야 합니다.")
    private final String password;
}
