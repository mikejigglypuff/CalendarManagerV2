package com.calendarManagerV2.advanced_lv1and2.dto.response.schedule;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.ScheduleResponseFormat;
import lombok.Getter;

@Getter
public class SchedulePostResDTO {
    private final String message;
    private final ScheduleResponseFormat scheduleFormat;

    public SchedulePostResDTO(ScheduleResponseFormat scheduleFormat) {
        this.scheduleFormat = scheduleFormat;
        this.message = "1개의 일정을 추가했습니다.";
    }
}
