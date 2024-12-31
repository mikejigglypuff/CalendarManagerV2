package com.calendarManagerV2.advanced_lv1and2.dto.request.schedule;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ScheduleDeleteReqDTO {
    @ValidPositiveNumber
    private final Long scheduleID;
}
