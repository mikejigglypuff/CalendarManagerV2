package com.calendarManagerV2.level8.mvc.repository;

import com.calendarManagerV2.level8.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepositoryInterface extends JpaRepository<Comment, Long> {
    Comment getFirstByCommentID(long commentID);
}
