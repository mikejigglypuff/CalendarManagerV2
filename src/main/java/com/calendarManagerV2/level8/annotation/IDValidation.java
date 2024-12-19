package com.calendarManagerV2.level8.annotation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 모든 테이블의 식별자 검증 사항 및 실패 메시지 관리용 애노테이션
@ConstraintComposition(CompositionType.AND)
@NotNull(message = "ID 값이 포함되어야 합니다.")
@Positive(message = "ID 값은 양의 정수여야 합니다.")
@ReportAsSingleViolation
@Schema(description = "필수 필드")
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IDValidation {
    String message() default "ID 값이 없거나 형식이 올바르지 않습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
