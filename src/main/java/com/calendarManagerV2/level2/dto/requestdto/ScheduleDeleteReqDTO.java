package com.calendarManagerV2.level2.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ScheduleDeleteReqDTO {
    private final Long scheduleID;
    private final String password;
}
