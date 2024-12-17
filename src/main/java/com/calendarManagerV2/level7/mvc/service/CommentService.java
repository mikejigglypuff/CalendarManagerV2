package com.calendarManagerV2.level7.mvc.service;

import com.calendarManagerV2.level7.dto.requestdto.CommentDeleteReqDTO;
import com.calendarManagerV2.level7.dto.requestdto.CommentGetReqDTO;
import com.calendarManagerV2.level7.dto.requestdto.CommentPatchReqDTO;
import com.calendarManagerV2.level7.dto.requestdto.CommentPostReqDTO;
import com.calendarManagerV2.level7.dto.responsedto.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level7.dto.responsedto.responseentity.CommentResponseFormat;
import com.calendarManagerV2.level7.entity.Comment;
import com.calendarManagerV2.level7.entity.User;
import com.calendarManagerV2.level7.mvc.repository.JpaCommentRepositoryInterface;
import com.calendarManagerV2.level7.mvc.repository.JpaScheduleRepositoryInterface;
import com.calendarManagerV2.level7.mvc.repository.JpaUserRepositoryInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CommentService {
    private final JpaCommentRepositoryInterface commentRepository;
    private final JpaScheduleRepositoryInterface scheduleRepository;
    private final JpaUserRepositoryInterface userRepository;
    private final ResponseFormatMapper<CommentResponseFormat, Comment> mapper;

    @Autowired
    public CommentService(
        JpaCommentRepositoryInterface commentRepository,
        JpaScheduleRepositoryInterface scheduleRepository,
        JpaUserRepositoryInterface userRepository,
        @Qualifier("commentMapper") ResponseFormatMapper<CommentResponseFormat, Comment> mapper
    ) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

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

        if(sessionUser.equals(comment.getUser())) {
            comment.setContent(dto.getContent());
        }

        return new CommentResponseFormat(commentRepository.save(comment));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteComment(CommentDeleteReqDTO dto, User sessionUser) {
        Comment comment = commentRepository.getFirstByCommentID(dto.getCommentID());

        if(sessionUser.equals(comment.getUser())) {
            commentRepository.delete(comment);
            return "댓글" + dto.getCommentID() + " 삭제 완료";
        }

        return "댓글 삭제 실패";
    }
}
