package com.calendarManagerV2.level1.mapper;

import com.calendarManagerV2.level1.dto.responsedto.responseentity.ScheduleResponseFormat;
import com.calendarManagerV2.level1.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("scheduleMapper")
public class ScheduleResponseFormatMapper implements ResponseFormatMaper<ScheduleResponseFormat, Schedule>{

    @Override
    public List<ScheduleResponseFormat> mapList(List<Schedule> list) {
        return list.stream()
            .map(schedule -> new ScheduleResponseFormat((Schedule)schedule))
            .toList();
    }
}
