package com.calendarManagerV2.level7.dto.requestdto;

import com.calendarManagerV2.level7.annotation.CommentContentValidation;
import com.calendarManagerV2.level7.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentPatchReqDTO {
    @IDValidation
    private final long commentID;
    @CommentContentValidation
    private final String content;
}
