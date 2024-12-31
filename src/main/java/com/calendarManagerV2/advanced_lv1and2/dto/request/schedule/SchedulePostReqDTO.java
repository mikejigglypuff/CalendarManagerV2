package com.calendarManagerV2.advanced_lv1and2.dto.request.schedule;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SchedulePostReqDTO {
    @ValidPositiveNumber
    private final Long userID;

    @Schema(description = "필수 항목")
    @NotNull(message = "일정 제목이 포함되어야 합니다.")
    @Size(max = 50, message = "제목은 50자 이하여야 합니다.")
    private final String title;

    @Schema(description = "필수 항목")
    @NotNull(message = "일정 내용이 포함되어야 합니다.")
    @Size(max = 255, message = "댓글은 255자 이하여야 합니다.")
    private final String content;
}
