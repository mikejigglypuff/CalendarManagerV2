package com.calendarManagerV2.level8.annotation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Size(max = 255, message = "댓글은 255자 이하여야 합니다.")
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Schema(description = "선택 필드", nullable = true)
public @interface CommentContentValidation {
    String message() default "댓글 형식이 올바르지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
