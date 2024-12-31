package com.calendarManagerV2.advanced_lv1and2.dto.response.schedule;


import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.ScheduleResponseFormat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// 단일 조회 및 여러 건 조회에 모두 쓰일 수 있도록 한 Response DTO
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
