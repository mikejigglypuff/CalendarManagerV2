package com.calendarManagerV2.level8.annotation;


import jakarta.validation.Payload;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 회원 이름 검증 사항 및 실패 메시지 관리용 애노테이션
@Size(max = 10, message = "이름은 10자 이하여야 합니다.")
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameValidation {
    String message() default "사용자 이름 형식이 올바르지 않습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
