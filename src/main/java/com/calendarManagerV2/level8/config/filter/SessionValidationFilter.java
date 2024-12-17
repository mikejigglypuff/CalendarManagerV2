package com.calendarManagerV2.level8.config.filter;

import com.calendarManagerV2.level8.enums.SessionValidationWhiteList;
import com.calendarManagerV2.level8.exception.NotValidSessionException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter("/*")
@Order(1)
@Slf4j
public class SessionValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        boolean passedChecks = true;

        if(!isWhiteList(req)) {
            passedChecks = checkValidSession(req.getSession(false), req.getRequestedSessionId(), res);
        }

        if(passedChecks) chain.doFilter(request, response);
    }

    private boolean isWhiteList(HttpServletRequest req) {
        SessionValidationWhiteList findValidatePattern = SessionValidationWhiteList.findRequestPattern(req);
        log.info("uri: " + req.getRequestURI() + ", method: " + req.getMethod());
        return findValidatePattern != null;
    }

    private boolean checkValidSession(
        HttpSession session, String requestID, HttpServletResponse res
    ) throws IOException {
        try {
            if (session == null) throw new NotValidSessionException("세션 없음");
            if (!session.getId().equals(requestID)) throw new NotValidSessionException("유효하지 않은 세션");
            return true;
        } catch (NotValidSessionException e) {
            log.info("세션: {}, 요청 세션 ID: {}\n{}", session, requestID, e.getMessage());
            res.setContentType("application/json");
            res.setCharacterEncoding("utf-8");
            res.setStatus(401);
            res.getWriter().write(e.getMessage());
            return false;
        }
    }
}
