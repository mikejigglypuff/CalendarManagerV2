package com.calendarManagerV2.level5.controller;

import com.calendarManagerV2.level5.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public class AbstractController {
    public User getSessionUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }
}
