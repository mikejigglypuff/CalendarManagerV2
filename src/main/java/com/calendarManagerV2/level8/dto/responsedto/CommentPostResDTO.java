package com.calendarManagerV2.level8.dto.responsedto;

import com.calendarManagerV2.level8.dto.responsedto.responseentity.CommentResponseFormat;
import lombok.Getter;

@Getter
public class CommentPostResDTO {
    private final String message = "1개의 댓글을 추가했습니다.";
    private final CommentResponseFormat comment;

    public CommentPostResDTO(CommentResponseFormat comment) {
        this.comment = comment;
    }
}
