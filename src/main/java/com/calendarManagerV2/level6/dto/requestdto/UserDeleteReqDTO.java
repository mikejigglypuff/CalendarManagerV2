package com.calendarManagerV2.level6.dto.requestdto;

import com.calendarManagerV2.level6.annotation.UserIDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDeleteReqDTO {
    @UserIDValidation
    private final long userID;
}