package com.calendarManagerV2.level6.dto.requestdto;

import com.calendarManagerV2.level6.annotation.ScheduleContentValidation;
import com.calendarManagerV2.level6.annotation.ScheduleTitleValidation;
import com.calendarManagerV2.level6.annotation.UserIDValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePostReqDTO {
    @UserIDValidation
    private final Long userID;

    @NotNull(message = "일정 제목이 포함되어야 합니다.")
    @ScheduleTitleValidation
    private final String title;

    @NotNull(message = "일정 내용이 포함되어야 합니다.")
    @ScheduleContentValidation
    private final String content;
}
