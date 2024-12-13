package com.calendarManagerV2.level1.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class SchedulePostReqDTO {
    private final Long userID;
    private final String title;
    private final String content;
}
