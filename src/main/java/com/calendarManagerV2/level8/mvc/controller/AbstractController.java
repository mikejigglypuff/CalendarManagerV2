package com.calendarManagerV2.level8.mvc.controller;

import com.calendarManagerV2.level8.entity.User;
import jakarta.servlet.http.HttpServletRequest;

// 컨트롤러에서만 공통적으로 요구되는 기능 구현
public class AbstractController {
    public User getSessionUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }
}
