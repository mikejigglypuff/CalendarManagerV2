package com.calendarManagerV2.level3.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserPatchReqDTO {
    private final String username;
    private final String email;
    private final String password;
}
