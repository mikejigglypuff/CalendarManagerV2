//package com.calendarManagerV2.level8.mvc.controller;
//
//import com.calendarManagerV2.level8.dto.requestdto.LoginReqDTO;
//import com.calendarManagerV2.level8.dto.responsedto.LoginResDTO;
//import com.calendarManagerV2.level8.dto.responsedto.LogoutResDTO;
//import com.calendarManagerV2.level8.entity.User;
//import com.calendarManagerV2.level8.mvc.service.UserService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/login")
//@RequiredArgsConstructor
//@Tag(name = "로그인 API", description = "유저 API 중 로그인 관련 부분을 분리해낸 API")
//public class LoginController {
//    private final UserService userService;
//
//    @Operation(summary = "로그인")
//    @PostMapping
//    public LoginResDTO login(@Valid @RequestBody LoginReqDTO dto, HttpServletRequest req) {
//        User user = userService.loginUser(dto);
//
//        // 서블릿 컨테이너가 응답에 자동으로 쿠키 추가
//        HttpSession session = req.getSession(true);
//        session.setAttribute("user", user);
//
//        return new LoginResDTO(user.getUsername());
//    }
//
//    @Operation(summary = "로그아웃", description = "미리 로그인되어 있어야 함")
//    @DeleteMapping
//    public LogoutResDTO logout(HttpServletRequest req, HttpServletResponse res) {
//        HttpSession session = req.getSession();
//        session.invalidate();
//
//        // 쿠키 삭제
//        Cookie cookie = new Cookie("JSESSIONID", null);
//        cookie.setPath("/");
//        cookie.setMaxAge(0);
//        res.addCookie(cookie);
//
//        return new LogoutResDTO();
//    }
//}
