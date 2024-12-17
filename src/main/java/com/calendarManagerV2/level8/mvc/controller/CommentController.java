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
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@Slf4j
public class CommentController extends AbstractController {
    private final CommentService service;

    @GetMapping("/{commentID}")
    public CommentGetResDTO getCommentByID(@Valid @IDValidation @PathVariable long commentID) {
        return new CommentGetResDTO(service.findCommentByID(new CommentGetReqDTO(commentID)));
    }

    @GetMapping
    public CommentGetResDTO getAllComment() {
        return new CommentGetResDTO(service.findAllComment());
    }

    @PostMapping
    public CommentPostResDTO postComment(@Valid @RequestBody CommentPostReqDTO dto) {
        return new CommentPostResDTO(service.addComment(dto));
    }

    @PatchMapping
    public CommentPatchResDTO patchComment(@Valid @RequestBody CommentPatchReqDTO dto, HttpServletRequest req) {
        return new CommentPatchResDTO(service.updateComment(dto, getSessionUser(req)));
    }

    @DeleteMapping
    public CommentDeleteResDTO deleteComment(@Valid @ModelAttribute CommentDeleteReqDTO dto, HttpServletRequest req) {
        return new CommentDeleteResDTO(service.deleteComment(dto, getSessionUser(req)));
    }
}
