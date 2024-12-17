package com.calendarManagerV2.level7.dto.responsedto.responseentity;

import com.calendarManagerV2.level7.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

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
