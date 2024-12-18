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
@Component
@WebFilter("/*")
@Order(2)
@Slf4j
public class RequestWrapperFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedReq = new ContentCachingRequestWrapper(req);
        ContentCachingResponseWrapper wrappedRes = new ContentCachingResponseWrapper(res);
        filterChain.doFilter(wrappedReq, wrappedRes);

        logRequest(wrappedReq);
        logResponse(wrappedRes);

        // 응답 본문 복사
        wrappedRes.copyBodyToResponse();
    }
    
    private void logRequest(ContentCachingRequestWrapper wrappedReq) throws IOException {
        log.info("Request URI: {}, Request Method: {}", wrappedReq.getRequestURI(), wrappedReq.getMethod());
        String requestBody = new String(wrappedReq.getContentAsByteArray(), wrappedReq.getCharacterEncoding());
        log.info("Request Body: {}", requestBody);
    }

    private void logResponse(ContentCachingResponseWrapper wrappedRes) throws IOException {
        log.info("Response Status: {}", wrappedRes.getStatus());
        String responseBody = new String(wrappedRes.getContentAsByteArray(), StandardCharsets.UTF_8);
        log.info("Response Body: {}", responseBody);
    }
}
