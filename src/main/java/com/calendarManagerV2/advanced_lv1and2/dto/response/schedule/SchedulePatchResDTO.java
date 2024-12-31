package com.calendarManagerV2.advanced_lv1and2.dto.response.schedule;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.ScheduleResponseFormat;
import lombok.Getter;

@Getter
public class SchedulePatchResDTO {
    private final String message;
    private final ScheduleResponseFormat scheduleFormat;

    public SchedulePatchResDTO(ScheduleResponseFormat scheduleFormat) {
        this.scheduleFormat = scheduleFormat;
        this.message = "1개의 일정을 수정했습니다.";
    }
}
