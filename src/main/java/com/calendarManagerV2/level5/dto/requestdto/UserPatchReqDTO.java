package com.calendarManagerV2.level5.dto.requestdto;

import com.calendarManagerV2.level5.annotation.UserEmailValidation;
import com.calendarManagerV2.level5.annotation.UserIDValidation;
import com.calendarManagerV2.level5.annotation.UsernameValidation;
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
