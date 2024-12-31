package com.calendarManagerV2.advanced_lv1and2.dto.request.comment;

import com.calendarManagerV2.advanced_lv1and2.exception.ValidationFailedException;
import com.calendarManagerV2.level7.annotation.IDValidation;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

// path variable을 표현하는 DTO
@Getter
@RequiredArgsConstructor
public class CommentGetReqDTO {
    @IDValidation
    private final Long commentID;
}
