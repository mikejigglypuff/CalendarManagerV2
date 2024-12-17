package com.calendarManagerV2.level6.controller;

import com.calendarManagerV2.level6.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public class AbstractController {
    public User getSessionUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }
}
