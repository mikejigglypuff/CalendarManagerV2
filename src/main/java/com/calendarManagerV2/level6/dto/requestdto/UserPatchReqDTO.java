package com.calendarManagerV2.level6.dto.requestdto;

import com.calendarManagerV2.level6.annotation.UserEmailValidation;
import com.calendarManagerV2.level6.annotation.UsernameValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserPatchReqDTO {
    @UsernameValidation
    private final String username;
    @UserEmailValidation
    private final String email;
}
