package com.calendarManagerV2.advanced_lv1and2.dto.request.schedule;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// path variable을 표현하는 DTO
@RequiredArgsConstructor
@Getter
public class ScheduleGetReqDTO {
    @ValidPositiveNumber
    private final Long userID;
}
