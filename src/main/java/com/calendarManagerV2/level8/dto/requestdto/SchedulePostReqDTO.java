package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.IDValidation;
import com.calendarManagerV2.level8.annotation.ScheduleContentValidation;
import com.calendarManagerV2.level8.annotation.ScheduleTitleValidation;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "필수 항목")
    private final String title;

    @NotNull(message = "일정 내용이 포함되어야 합니다.")
    @ScheduleContentValidation
    @Schema(description = "필수 항목")
    private final String content;
}
