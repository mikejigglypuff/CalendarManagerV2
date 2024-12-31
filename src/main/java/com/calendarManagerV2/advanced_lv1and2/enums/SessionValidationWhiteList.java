package com.calendarManagerV2.advanced_lv1and2.enums;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.util.Arrays;

// 세션 검사에서 제외할 요청 형식들의 목록을 정의
@Getter
public enum SessionValidationWhiteList {
    REGISTER("/api/user", HttpMethod.POST),
    LOGIN("/api/login", HttpMethod.POST),
    API_DOCUMENT("/v3/api-docs", HttpMethod.GET),
    API_REGEX("^/v3/api-docs(/.*)?$", HttpMethod.GET),
    FAV_ICO("/favicon.ico", HttpMethod.GET),
    SWAGGER_UI("/swagger-ui.html", HttpMethod.GET),
    SWAGGER_REGEX("^/swagger-ui(/.*)?$", HttpMethod.GET);

    private final String uri;
    private final String method;

    SessionValidationWhiteList(String uri, HttpMethod method) {
        this.uri = uri;
        this.method = method.name();
    }

    public static SessionValidationWhiteList findRequestPattern(HttpServletRequest req) {
        return Arrays.stream(values())
            .filter(val -> ( // 문자열이 일치하지 않는 경우에만 정규식 수행하도록 함
                (val.getUri().equals(req.getRequestURI())) || req.getRequestURI().matches(val.getUri()))
                && val.getMethod().equals(req.getMethod())
            ).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "SessionValidationWhiteList{" +
            "uri='" + uri + '\'' +
            ", method='" + method + '\'' +
            '}';
    }
}
