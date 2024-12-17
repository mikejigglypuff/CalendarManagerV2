package com.calendarManagerV2.level7.dto.requestdto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentDeleteReqDTO {
    private final Long commentID;
}
