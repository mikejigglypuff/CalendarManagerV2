package com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity;

import com.calendarManagerV2.advanced_lv1and2.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

// Comment의 User, Schedule를 그대로 전달하는 대신 username, scheduleID만 전달하도록 하는 응답 형식
@Getter
public class CommentResponseFormat {
    private final long commentID;
    private final String username;
    private final long scheduleID;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentResponseFormat(Comment comment) {
        this.commentID = comment.getCommentID();
        this.username = comment.getUser().getUsername();
        this.scheduleID = comment.getSchedule().getScheduleID();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
