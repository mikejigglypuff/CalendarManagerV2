package com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity;

import com.calendarManagerV2.advanced_lv1and2.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

// Schedule의 User 전체 대신 username만 전달하도록 하는 응답 형식
@Getter
public class ScheduleResponseFormat {
    private final long scheduleID;
    private final String username;
    private final String title;
    private final String content;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponseFormat(Schedule schedule) {
        this.scheduleID = schedule.getScheduleID();
        this.username = schedule.getUser().getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.commentCount = schedule.getCommentList().size();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
