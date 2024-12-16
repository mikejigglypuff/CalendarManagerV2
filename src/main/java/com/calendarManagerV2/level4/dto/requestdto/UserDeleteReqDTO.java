package com.calendarManagerV2.level4.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDeleteReqDTO {
    private final long userID;
    private final String password;
}
