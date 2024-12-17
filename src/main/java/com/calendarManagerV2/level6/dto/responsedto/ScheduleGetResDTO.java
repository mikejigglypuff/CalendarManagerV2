package com.calendarManagerV2.level6.dto.responsedto;


import com.calendarManagerV2.level6.dto.responsedto.responseentity.ScheduleResponseFormat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ScheduleGetResDTO {
    private final String message;
    private final List<ScheduleResponseFormat> scheduleList;

    public ScheduleGetResDTO(ScheduleResponseFormat schedule) {
        this.scheduleList = new ArrayList<>();
        this.scheduleList.add(schedule);
        message = "1개의 일정을 조회했습니다.";
    }

    public ScheduleGetResDTO(List<ScheduleResponseFormat> schedules) {
        this.scheduleList = schedules;
        message = schedules.size() + "개의 일정을 조회했습니다.";
    }
}
