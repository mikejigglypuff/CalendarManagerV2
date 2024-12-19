package com.calendarManagerV2.level8.mvc.controller;

import com.calendarManagerV2.level8.annotation.IDValidation;
import com.calendarManagerV2.level8.dto.requestdto.CommentDeleteReqDTO;
import com.calendarManagerV2.level8.dto.requestdto.CommentGetReqDTO;
import com.calendarManagerV2.level8.dto.requestdto.CommentPatchReqDTO;
import com.calendarManagerV2.level8.dto.requestdto.CommentPostReqDTO;
import com.calendarManagerV2.level8.dto.responsedto.CommentDeleteResDTO;
import com.calendarManagerV2.level8.dto.responsedto.CommentGetResDTO;
import com.calendarManagerV2.level8.dto.responsedto.CommentPatchResDTO;
import com.calendarManagerV2.level8.dto.responsedto.CommentPostResDTO;
import com.calendarManagerV2.level8.mvc.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Tag(name = "댓글 API", description = "댓글 관련 API, 접근 시 로그인 필요")
public class CommentController extends AbstractController {
    private final CommentService service;

    @Operation(summary = "댓글 ID로 단일 댓글 조회")
    @GetMapping("/{commentID}")
    public CommentGetResDTO getCommentByID(@Valid @IDValidation @PathVariable long commentID) {
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
    public CommentPatchResDTO patchComment(@Valid @RequestBody CommentPatchReqDTO dto, HttpServletRequest req) {
        return new CommentPatchResDTO(service.updateComment(dto, getSessionUser(req)));
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping
    public CommentDeleteResDTO deleteComment(@Valid @ModelAttribute CommentDeleteReqDTO dto, HttpServletRequest req) {
        return new CommentDeleteResDTO(service.deleteComment(dto, getSessionUser(req)));
    }
}
