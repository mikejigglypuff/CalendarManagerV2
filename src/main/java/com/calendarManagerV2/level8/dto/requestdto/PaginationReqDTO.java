package com.calendarManagerV2.level8.dto.requestdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

// 페이징 처리에 사용되는 범용 DTO
@Getter
@Schema(description = "선택 항목", nullable = true)
public class PaginationReqDTO {
    @PositiveOrZero
    private final Integer offset;

    @Positive
    private final Integer size;

    public PaginationReqDTO(Integer offset, Integer size) {
        this.offset = offset;
        this.size = (size != null) ? size : 10;
    }

    // service 계층에서 페이징 처리가 필요한지를 알 수 있도록 하는 메서드
    public boolean isPaging() {
        return offset != null;
    }
}
