package com.calendarManagerV2.level7.dto.requestdto;

import com.calendarManagerV2.level7.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentGetReqDTO {
    @IDValidation
    private final Long commentID;
}
