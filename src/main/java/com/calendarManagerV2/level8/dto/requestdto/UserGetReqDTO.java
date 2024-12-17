package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserGetReqDTO {
    @IDValidation
    private final Long userID;
}