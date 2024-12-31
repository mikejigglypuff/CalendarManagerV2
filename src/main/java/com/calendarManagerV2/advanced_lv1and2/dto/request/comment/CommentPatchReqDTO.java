package com.calendarManagerV2.advanced_lv1and2.dto.request.comment;

import com.calendarManagerV2.advanced_lv1and2.exception.ValidationFailedException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
@Getter
public class CommentPatchReqDTO {
    private final Long commentID;
    @Schema(description = "선택 항목", nullable = true)
    private final String content;

    public CommentPatchReqDTO(Long commentID, String content) {
        this.commentID = commentID;
        this.content = content;
        validate();
    }

    // 값에 null이 들어올 수 있는 경우에 대한 Validation 구현
    private void validate() {
        if(commentID == null) throw new ValidationFailedException("commentID가 포함되어야 합니다.");
        if(commentID <= 0) throw new ValidationFailedException("commentID는 양의 정수여야 합니다.");

        if(content != null && content.length() > 255)
            throw new ValidationFailedException("content는 255자 이하로 입력해주세요.");
    }
}
