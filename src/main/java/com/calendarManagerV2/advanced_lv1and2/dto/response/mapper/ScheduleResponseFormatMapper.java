package com.calendarManagerV2.advanced_lv1and2.dto.response.mapper;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.advanced_lv1and2.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleResponseFormatMapper implements ResponseFormatMapper<ScheduleResponseFormat, Schedule> {

    @Override
    public List<ScheduleResponseFormat> mapList(List<Schedule> list) {
        return list.stream()
            .map(ScheduleResponseFormat::new)
            .toList();
    }
}
