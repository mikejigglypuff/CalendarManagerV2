package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.IDValidation;
import com.calendarManagerV2.level8.annotation.ScheduleContentValidation;
import com.calendarManagerV2.level8.annotation.ScheduleTitleValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePatchReqDTO {
    @IDValidation
    private final Long scheduleID;

    @NotBlank(message = "일정 제목은 빈 문자열이 될 수 없습니다.")
    @ScheduleTitleValidation
    @Schema(description = "선택 항목", nullable = true)
    private final String title;

    @NotBlank(message = "일정 내용은 빈 문자열이 될 수 없습니다.")
    @ScheduleContentValidation
    @Schema(description = "선택 항목", nullable = true)
    private final String content;
}
