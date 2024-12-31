package com.calendarManagerV2.advanced_lv1and2.mvc.repository;

import com.calendarManagerV2.advanced_lv1and2.entity.Comment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Spring Data JPA의 Query Method 기반 Repository
public interface JpaCommentRepositoryInterface extends JpaRepository<Comment, Long> {
    // 1 + N 방지
    @EntityGraph(attributePaths = {"user", "schedule"})
    Comment getFirstByCommentID(long commentID);

    // 기본적으로 생성되는 findAll에 EntityGraph 적용
    @Override
    @EntityGraph(attributePaths = {"user", "schedule"})
    List<Comment> findAll();
}
