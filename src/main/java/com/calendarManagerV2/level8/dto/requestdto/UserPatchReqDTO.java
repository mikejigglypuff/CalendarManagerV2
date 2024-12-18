package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.UserEmailValidation;
import com.calendarManagerV2.level8.annotation.UsernameValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserPatchReqDTO {
    @UsernameValidation
    private final String username;
    @UserEmailValidation
    @Schema(description = "선택 항목", nullable = true)
    private final String email;
}
