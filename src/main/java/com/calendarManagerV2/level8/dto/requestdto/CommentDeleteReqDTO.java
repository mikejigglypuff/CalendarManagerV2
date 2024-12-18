package com.calendarManagerV2.level8.dto.requestdto;

import com.calendarManagerV2.level7.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentDeleteReqDTO {
    @IDValidation
    private final Long commentID;
}
