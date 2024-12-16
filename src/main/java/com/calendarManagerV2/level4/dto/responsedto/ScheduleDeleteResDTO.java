package com.calendarManagerV2.level4.dto.responsedto;

import lombok.Getter;

@Getter
public class ScheduleDeleteResDTO {
    private final String message;

    public ScheduleDeleteResDTO(String message) {
        this.message = message + " 일정을 삭제했습니다.";
    }
}
