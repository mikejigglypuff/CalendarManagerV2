package com.calendarManagerV2.advanced_lv1and2.exception;

// 전송한 쿠키가 없거나 유효하지 않은 상황을 표현하기 위한 커스텀 예외
public class NotValidSessionException extends RuntimeException {
    public NotValidSessionException(String message) {
        super("인증 실패: " + message);
    }
}
