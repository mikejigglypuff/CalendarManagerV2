package com.calendarManagerV2.level7.dto.requestdto;

import com.calendarManagerV2.level7.annotation.IDValidation;
import com.calendarManagerV2.level7.annotation.ScheduleContentValidation;
import com.calendarManagerV2.level7.annotation.ScheduleTitleValidation;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePostReqDTO {
    @IDValidation
    private final Long userID;

    @NotNull(message = "일정 제목이 포함되어야 합니다.")
    @ScheduleTitleValidation
    private final String title;

    @NotNull(message = "일정 내용이 포함되어야 합니다.")
    @ScheduleContentValidation
    private final String content;
}
