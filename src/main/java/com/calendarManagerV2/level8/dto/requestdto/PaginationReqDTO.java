package com.calendarManagerV2.level8.dto.requestdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

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

    public boolean isPaging() { return offset != null; }
}
