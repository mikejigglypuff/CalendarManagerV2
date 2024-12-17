package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level8.annotation.CommentContentValidation;
import com.calendarManagerV2.level8.annotation.IDValidation;
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
    private final String content;
}