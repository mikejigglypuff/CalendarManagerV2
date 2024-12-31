package com.calendarManagerV2.advanced_lv1and2.dto.request.comment;

import com.calendarManagerV2.advanced_lv1and2.exception.ValidationFailedException;
import com.calendarManagerV2.level7.annotation.IDValidation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RequiredArgsConstructor
@Getter
public class CommentDeleteReqDTO {
    @IDValidation
    private final Long commentID;
}
