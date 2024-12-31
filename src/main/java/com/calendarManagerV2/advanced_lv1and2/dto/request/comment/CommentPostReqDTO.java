package com.calendarManagerV2.advanced_lv1and2.dto.request.comment;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentPostReqDTO {
    @ValidPositiveNumber
    private final Long userID;

    @ValidPositiveNumber
    private final Long scheduleID;

    @Schema(description = "선택 항목", nullable = true)
    @NotNull
    @Size(max = 255, message = "댓글은 255자 이하여야 합니다.")
    private final String content;
}
