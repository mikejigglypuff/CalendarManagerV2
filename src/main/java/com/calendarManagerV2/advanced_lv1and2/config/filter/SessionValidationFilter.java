package com.calendarManagerV2.advanced_lv1and2.config.filter;

import com.calendarManagerV2.advanced_lv1and2.enums.SessionValidationWhiteList;
import com.calendarManagerV2.advanced_lv1and2.exception.NotValidSessionException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 세션 검증 및 검증 실패 시 401 응답을 전송하도록 하는 필터
// SessionValidationWhiteList에 정의된 URL들은 검증 제외
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

        if (!isWhiteList(req)) {
            passedChecks = checkValidSession(req.getSession(false), req.getRequestedSessionId(), res);
        }

        if (passedChecks) chain.doFilter(request, response);
    }

    private boolean isWhiteList(HttpServletRequest req) {
        SessionValidationWhiteList findValidatePattern = SessionValidationWhiteList.findRequestPattern(req);

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
            res.setContentType("application/json");
            res.setCharacterEncoding("utf-8");
            res.setStatus(401);
            res.getWriter().write(e.getMessage());
            return false;
        }
    }
}
