package com.calendarManagerV2.level8.config.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

// getReader()로 요청 Body를 여러 번 읽을 수 있도록 요청을 래핑하는 필터
//@Component
//@WebFilter("/*")
//@Order(2)
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedReq = new ContentCachingRequestWrapper(req);
        ContentCachingResponseWrapper wrappedRes = new ContentCachingResponseWrapper(res);
        filterChain.doFilter(wrappedReq, wrappedRes);

        logRequest(wrappedReq);
        logResponse(wrappedRes);

        // 응답 본문이 로깅으로 소비되어 클라이언트에 전송되지 않는 현상 방지
        wrappedRes.copyBodyToResponse();
    }

    private void logRequest(ContentCachingRequestWrapper wrappedReq) throws IOException {
        log.info("Request URI: {}, Request Method: {}", wrappedReq.getRequestURI(), wrappedReq.getMethod());
        log.info("Current Session: {}, Request Session ID: {}", wrappedReq.getSession(), wrappedReq.getRequestedSessionId());
        log.info("Request Body: {}", new String(wrappedReq.getContentAsByteArray(), wrappedReq.getCharacterEncoding()));
    }

    private void logResponse(ContentCachingResponseWrapper wrappedRes) throws IOException {
        log.info("Response Status: {}", wrappedRes.getStatus());
        // 요청과 달리 응답 로깅 시에는 인코딩이 깨질 수 있어 강제로 UTF-8 사용하도록 함
        log.info("Response Body: {}", new String(wrappedRes.getContentAsByteArray(), StandardCharsets.UTF_8));
    }
}
