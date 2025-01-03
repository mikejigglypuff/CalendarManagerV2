package com.calendarManagerV2.advanced_lv1and2.mvc.service;

import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentDeleteReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentGetReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentPatchReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentPostReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.mapper.ResponseFormatMapper;
import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.CommentResponseFormat;
import com.calendarManagerV2.advanced_lv1and2.entity.Comment;
import com.calendarManagerV2.advanced_lv1and2.entity.User;
import com.calendarManagerV2.advanced_lv1and2.mvc.repository.JpaCommentRepositoryInterface;
import com.calendarManagerV2.advanced_lv1and2.mvc.repository.JpaScheduleRepositoryInterface;
import com.calendarManagerV2.advanced_lv1and2.mvc.repository.JpaUserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final JpaCommentRepositoryInterface commentRepository;
    private final JpaScheduleRepositoryInterface scheduleRepository;
    private final JpaUserRepositoryInterface userRepository;
    private final ResponseFormatMapper<CommentResponseFormat, Comment> mapper;

    // Query Method 기반 Repository를 사용하므로 Service 계층에서 Transaction Rollback 담당
    @Transactional(rollbackFor = {DataAccessException.class})
    public List<CommentResponseFormat> findAllComment() {
        return mapper.mapList(commentRepository.findAll());
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public CommentResponseFormat findCommentByID(CommentGetReqDTO dto) {
        return new CommentResponseFormat(commentRepository.getFirstByCommentID(dto.getCommentID()));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public CommentResponseFormat addComment(CommentPostReqDTO dto) {
        Comment comment = new Comment(dto);
        comment.setSchedule(scheduleRepository.findFirstByScheduleID(dto.getScheduleID()));
        comment.setUser(userRepository.findFirstByUserID(dto.getUserID()));
        return new CommentResponseFormat(commentRepository.save(comment));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public CommentResponseFormat updateComment(CommentPatchReqDTO dto, User sessionUser) {
        Comment comment = commentRepository.getFirstByCommentID(dto.getCommentID());

        // 작성자와 수정 요청을 보낸 회원이 동일한지 확인
        if (sessionUser.equals(comment.getUser())) {
            comment.setContent(dto.getContent());
        }

        return new CommentResponseFormat(commentRepository.save(comment));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteComment(CommentDeleteReqDTO dto, User sessionUser) {
        Comment comment = commentRepository.getFirstByCommentID(dto.getCommentID());

        // 작성자와 삭제 요청을 보낸 사람이 동일한지 확인
        if (sessionUser.equals(comment.getUser())) {
            commentRepository.delete(comment);
            return "댓글" + dto.getCommentID() + " 삭제 완료";
        }

        return "댓글 삭제 실패";
    }
}
