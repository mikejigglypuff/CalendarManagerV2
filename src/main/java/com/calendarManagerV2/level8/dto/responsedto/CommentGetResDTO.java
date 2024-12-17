package com.calendarManagerV2.level8.dto.responsedto;

import com.calendarManagerV2.level8.dto.responsedto.responseentity.CommentResponseFormat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommentGetResDTO {
    private final String message;
    private final List<CommentResponseFormat> commentList;

    public CommentGetResDTO(List<CommentResponseFormat> commentList) {
        this.commentList = commentList;
        this.message = commentList.size() + "개의 댓글을 조회했습니다.";
    }

    public CommentGetResDTO(CommentResponseFormat comment) {
        this.commentList = new ArrayList<>();
        commentList.add(comment);
        this.message = "1개의 댓글을 조회했습니다.";
    }
}
