package com.calendarManagerV2.level3.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ScheduleGetReqDTO {
    private final Long userID;
}