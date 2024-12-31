package com.calendarManagerV2.advanced_lv1and2.mvc.controller;

import com.calendarManagerV2.advanced_lv1and2.annotation.ValidPositiveNumber;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentDeleteReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentGetReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentPatchReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.comment.CommentPostReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.comment.CommentDeleteResDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.comment.CommentGetResDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.comment.CommentPatchResDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.comment.CommentPostResDTO;
import com.calendarManagerV2.advanced_lv1and2.mvc.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Tag(name = "댓글 API", description = "댓글 관련 API, 접근 시 로그인 필요")
public class CommentController extends AbstractController {
    private final CommentService service;

    @Operation(summary = "댓글 ID로 단일 댓글 조회")
    @GetMapping("/{commentID}")
    public CommentGetResDTO getCommentByID(@Validated @ValidPositiveNumber @PathVariable long commentID) {
        return new CommentGetResDTO(service.findCommentByID(new CommentGetReqDTO(commentID)));
    }

    @Operation(summary = "댓글 전체 조회")
    @GetMapping
    public CommentGetResDTO getAllComment() {
        return new CommentGetResDTO(service.findAllComment());
    }

    @Operation(summary = "댓글 등록")
    @PostMapping
    public CommentPostResDTO postComment(@Valid @RequestBody CommentPostReqDTO dto) {
        return new CommentPostResDTO(service.addComment(dto));
    }

    @Operation(summary = "댓글 내용 수정")
    @PatchMapping
    public CommentPatchResDTO patchComment(@RequestBody CommentPatchReqDTO dto, HttpServletRequest req) {
        return new CommentPatchResDTO(service.updateComment(dto, getSessionUser(req)));
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping
    public CommentDeleteResDTO deleteComment(@Valid @ModelAttribute CommentDeleteReqDTO dto, HttpServletRequest req) {
        return new CommentDeleteResDTO(service.deleteComment(dto, getSessionUser(req)));
    }
}
