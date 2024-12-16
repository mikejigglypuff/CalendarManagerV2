package com.calendarManagerV2.level5.dto.requestdto;

import com.calendarManagerV2.level5.annotation.UserIDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDeleteReqDTO {
    @UserIDValidation
    private final long userID;
}
