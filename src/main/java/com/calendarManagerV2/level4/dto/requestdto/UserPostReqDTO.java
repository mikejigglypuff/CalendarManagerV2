package com.calendarManagerV2.level4.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserPostReqDTO {
    private final String username;
    private final String email;
    private final String password;
}
