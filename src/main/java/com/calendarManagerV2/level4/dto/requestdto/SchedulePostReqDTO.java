package com.calendarManagerV2.level4.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePostReqDTO {
    private final Long userID;
    private final String title;
    private final String content;
}
