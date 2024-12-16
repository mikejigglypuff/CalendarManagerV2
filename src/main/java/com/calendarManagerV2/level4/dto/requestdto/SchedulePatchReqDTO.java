package com.calendarManagerV2.level4.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePatchReqDTO {
    private final Long scheduleID;
    private final String title;
    private final String content;
    private final String password;
}
