package com.calendarManagerV2.level5.dto.requestdto;

import com.calendarManagerV2.level5.annotation.UserIDValidation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ScheduleGetReqDTO {
    @UserIDValidation
    private final Long userID;
}
