package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.CommentContentValidation;
import com.calendarManagerV2.level8.annotation.IDValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentPostReqDTO {
    @IDValidation
    private final Long userID;

    @IDValidation
    private final Long scheduleID;

    @CommentContentValidation
    @Schema(description = "선택 항목", nullable = true)
    private final String content;
}
