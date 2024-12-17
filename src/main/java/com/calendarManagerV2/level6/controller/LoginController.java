package com.calendarManagerV2.level6.controller;

import com.calendarManagerV2.level6.dto.requestdto.LoginReqDTO;
import com.calendarManagerV2.level6.dto.responsedto.LoginResDTO;
import com.calendarManagerV2.level6.dto.responsedto.LogoutResDTO;
import com.calendarManagerV2.level6.entity.User;
import com.calendarManagerV2.level6.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping
    public LoginResDTO login(@Valid @RequestBody LoginReqDTO dto, HttpServletRequest req) {
        User user = userService.loginUser(dto);

        // 서블릿 컨테이너가 응답에 자동으로 쿠키 추가
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);

        return new LoginResDTO(user.getUsername());
    }

    @DeleteMapping
    public LogoutResDTO logout(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        session.invalidate();

        // 쿠키 삭제
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);

        return new LogoutResDTO();
    }
}
