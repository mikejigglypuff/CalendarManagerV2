package com.calendarManagerV2.level5.enums;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.util.Arrays;

@Getter
public enum SessionValidationWhiteList {
    REGISTER("/api/user", HttpMethod.POST),
    LOGIN("/api/login", HttpMethod.POST);

    private final String uri;
    private final String method;

    SessionValidationWhiteList(String uri, HttpMethod method) {
        this.uri = uri;
        this.method = method.name();
    }

    public static SessionValidationWhiteList findRequestPattern(HttpServletRequest req) {
        return Arrays.stream(values())
            .filter(val -> (
                val.getUri().equals(req.getRequestURI())) && val.getMethod().equals(req.getMethod())
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
