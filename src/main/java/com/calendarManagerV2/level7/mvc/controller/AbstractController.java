package com.calendarManagerV2.level7.mvc.controller;

import com.calendarManagerV2.level7.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public class AbstractController {
    public User getSessionUser(HttpServletRequest req) {
        return (User) req.getSession().getAttribute("user");
    }
}