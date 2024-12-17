package com.calendarManagerV2.level6.dto.requestdto;

import com.calendarManagerV2.level6.annotation.ScheduleIDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ScheduleDeleteReqDTO {
    @ScheduleIDValidation
    private final Long scheduleID;
}
