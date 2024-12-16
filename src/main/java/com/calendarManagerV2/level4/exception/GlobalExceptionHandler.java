package com.calendarManagerV2.level4.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(NotValidSessionException.class)
    public ResponseEntity<String> handleNotValidSessionException(NotValidSessionException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
