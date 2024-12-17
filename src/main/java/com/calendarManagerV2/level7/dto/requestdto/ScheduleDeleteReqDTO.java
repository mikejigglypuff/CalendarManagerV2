package com.calendarManagerV2.level7.dto.requestdto;

import com.calendarManagerV2.level7.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ScheduleDeleteReqDTO {
    @IDValidation
    private final Long scheduleID;
}
