package com.calendarManagerV2.level7.dto.responsedto.mapper;

import com.calendarManagerV2.level7.dto.responsedto.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.level7.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("scheduleMapper")
public class ScheduleResponseFormatMapper implements ResponseFormatMapper<ScheduleResponseFormat, Schedule> {

    @Override
    public List<ScheduleResponseFormat> mapList(List<Schedule> list) {
        return list.stream()
            .map(ScheduleResponseFormat::new)
            .toList();
    }
}
