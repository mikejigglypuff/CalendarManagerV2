package com.calendarManagerV2.advanced_lv1and2.dto.request;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import com.calendarManagerV2.advanced_lv1and2.exception.ValidationFailedException;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

// 페이징 처리에 사용되는 범용 DTO
@Getter
@Schema(description = "선택 항목", nullable = true)
public class PaginationReqDTO {
    private final Integer offset;
    private final Integer size;

    public PaginationReqDTO(Integer offset, Integer size) {
        this.offset = offset;
        this.size = (size != null) ? size : 10;

        validate();
    }

    // service 계층에서 페이징 처리가 필요한지를 알 수 있도록 하는 메서드
    public boolean isPaging() {
        return offset != null;
    }

    private void validate() {
        if(offset == null) throw new ValidationFailedException("offset이 포함되어야 합니다.");
        if(size <= 0) throw new ValidationFailedException("size는 양의 정수여야 합니다.");
    }
}
