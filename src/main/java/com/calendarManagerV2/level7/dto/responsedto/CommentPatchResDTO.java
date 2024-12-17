package com.calendarManagerV2.level7.dto.responsedto;

import com.calendarManagerV2.level7.dto.responsedto.responseentity.CommentResponseFormat;
import lombok.Getter;

@Getter
public class CommentPatchResDTO {
    private final String message = "1개의 댓글이 수정되었습니다.";
    private final CommentResponseFormat comment;

    public CommentPatchResDTO(CommentResponseFormat comment) {
        this.comment = comment;
    }
}
