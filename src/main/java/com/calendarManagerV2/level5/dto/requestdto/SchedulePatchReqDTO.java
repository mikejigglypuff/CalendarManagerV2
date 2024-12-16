package com.calendarManagerV2.level5.dto.requestdto;

import com.calendarManagerV2.level5.annotation.ScheduleContentValidation;
import com.calendarManagerV2.level5.annotation.ScheduleIDValidation;
import com.calendarManagerV2.level5.annotation.ScheduleTitleValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePatchReqDTO {
    @ScheduleIDValidation
    private final Long scheduleID;

    @NotBlank(message = "일정 제목은 빈 문자열이 될 수 없습니다.")
    @ScheduleTitleValidation
    private final String title;

    @NotBlank(message = "일정 내용은 빈 문자열이 될 수 없습니다.")
    @ScheduleContentValidation
    private final String content;
}
