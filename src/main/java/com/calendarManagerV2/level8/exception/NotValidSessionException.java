package com.calendarManagerV2.level8.exception;

public class NotValidSessionException extends RuntimeException {
    public NotValidSessionException(String message) { super("인증 실패: " + message); }
}
