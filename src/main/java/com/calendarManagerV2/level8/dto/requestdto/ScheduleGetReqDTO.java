package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// path variable을 표현하는 DTO
@RequiredArgsConstructor
@Getter
public class ScheduleGetReqDTO {
    @IDValidation
    private final Long userID;
}
