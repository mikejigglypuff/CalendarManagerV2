package com.calendarManagerV2.advanced_lv1and2.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// 프로젝트 전역에서 발생한 예외들에 대해 알맞은 Response Status 및 메시지를 붙여 응답하도록 함
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotValidSessionException.class)
    public ResponseEntity<String> handleNotValidSessionException(NotValidSessionException e) {
        return makeStringResBody(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler({
        NoSuchElementException.class,
        NoResourceFoundException.class,
        IllegalArgumentException.class,
        ValidationFailedException.class,
        MissingPathVariableException.class,
        ConstraintViolationException.class,
        DataIntegrityViolationException.class,
        InvalidDataAccessApiUsageException.class,
        MethodArgumentTypeMismatchException.class
    })
    public ResponseEntity<String> handleBadRequests(Exception e) {
        return makeStringResBody(HttpStatus.BAD_REQUEST, "잘못된 요청: " + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 여러 필드들의 validator에서 발생한 문제들을 모두 HTTP response body에 저장
        Map<String, String> body = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
            body.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<String> handleHandlerMethodValidationException(HandlerMethodValidationException e) {
        String messages = Arrays.stream(e.getDetailMessageArguments())
            .map(Object::toString)
            .collect(Collectors.joining("\n"));
        return makeStringResBody(HttpStatus.BAD_REQUEST, messages);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return makeStringResBody(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    public ResponseEntity<String> handleIncorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException e) {
        return makeStringResBody(HttpStatus.CONFLICT, "조회 결과가 예상보다 많습니다.");
    }

    // 반복되는 ResponseEntity 설정 코드 간소화
    private ResponseEntity<String> makeStringResBody(HttpStatus status, String body) {
        return ResponseEntity.status(status).body(body);
    }
}
