package com.calendarManagerV2.advanced_lv1and2.dto.request.schedule;

import com.calendarManagerV2.advanced_lv1and2.exception.ValidationFailedException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class SchedulePatchReqDTO {
    private final Long scheduleID;

    @Schema(description = "선택 항목", nullable = true)
    private final String title;

    @Schema(description = "선택 항목", nullable = true)
    private final String content;

    public SchedulePatchReqDTO(Long scheduleID, String title, String content) {
        this.scheduleID = scheduleID;
        this.title = title;
        this.content = content;
        validate();
    }

    // 값에 null이 들어올 수 있는 경우에 대한 Validation 구현
    private void validate() {
        if(scheduleID == null) throw new ValidationFailedException("scheduleID가 포함되어야 합니다.");
        if(scheduleID <= 0) throw new ValidationFailedException("scheduleID는 양의 정수여야 합니다.");

        if(title != null && title.length() > 50) throw new ValidationFailedException("title은 50자 이하여야 합니다.");
        if(content != null && content.length() > 255) throw new ValidationFailedException("title은 255자 이하여야 합니다.");
    }
}
