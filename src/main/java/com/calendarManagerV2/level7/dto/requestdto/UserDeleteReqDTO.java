package com.calendarManagerV2.level7.dto.requestdto;

import com.calendarManagerV2.level7.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserDeleteReqDTO {
    @IDValidation
    private final long userID;
}
