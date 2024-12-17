package com.calendarManagerV2.level7.dto.responsedto.mapper;

import com.calendarManagerV2.level7.dto.responsedto.responseentity.CommentResponseFormat;
import com.calendarManagerV2.level7.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("commentMapper")
public class CommentResponseFormatMapper implements ResponseFormatMapper<CommentResponseFormat, Comment> {

    @Override
    public List<CommentResponseFormat> mapList(List<Comment> list) {
        return list.stream()
            .map(CommentResponseFormat::new)
            .toList();
    }
}
