package com.calendarManagerV2.level8.mvc.repository;

import com.calendarManagerV2.level8.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA의 Query Method 기반 Repository
public interface JpaCommentRepositoryInterface extends JpaRepository<Comment, Long> {
    Comment getFirstByCommentID(long commentID);
}
