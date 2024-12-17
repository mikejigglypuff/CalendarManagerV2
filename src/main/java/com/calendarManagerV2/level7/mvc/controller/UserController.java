//package com.calendarManagerV2.level7.mvc.controller;
//
//import com.calendarManagerV2.level7.annotation.IDValidation;
//import com.calendarManagerV2.level7.dto.requestdto.UserDeleteReqDTO;
//import com.calendarManagerV2.level7.dto.requestdto.UserGetReqDTO;
//import com.calendarManagerV2.level7.dto.requestdto.UserPatchReqDTO;
//import com.calendarManagerV2.level7.dto.requestdto.UserPostReqDTO;
//import com.calendarManagerV2.level7.dto.responsedto.UserDeleteResDTO;
//import com.calendarManagerV2.level7.dto.responsedto.UserGetResDTO;
//import com.calendarManagerV2.level7.dto.responsedto.UserPatchResDTO;
//import com.calendarManagerV2.level7.dto.responsedto.UserPostResDTO;
//import com.calendarManagerV2.level7.mvc.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Positive;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/api/user")
//@RequiredArgsConstructor
//@Slf4j
//public class UserController extends AbstractController {
//    private final UserService service;
//
//    @GetMapping("/{userID}")
//    public UserGetResDTO getUserByUserID(@Valid @IDValidation @PathVariable Long userID) {
//        return new UserGetResDTO(service.findUserByUserID(new UserGetReqDTO(userID)));
//    }
//
//    @GetMapping
//    public UserGetResDTO getAllUsers() {
//        return new UserGetResDTO(service.findAllUsers());
//    }
//
//    @PostMapping
//    public UserPostResDTO postUser(@Valid @RequestBody UserPostReqDTO dto) {
//        return new UserPostResDTO(service.addUser(dto));
//    }
//
//    @PatchMapping
//    public UserPatchResDTO patchUser(@Valid @RequestBody UserPatchReqDTO dto, HttpServletRequest req) {
//        return new UserPatchResDTO(service.updateUser(dto, getSessionUser(req)));
//    }
//
//    @DeleteMapping
//    public UserDeleteResDTO deleteUser(@Valid @ModelAttribute UserDeleteReqDTO dto, HttpServletRequest req) {
//        return new UserDeleteResDTO(service.deleteUser(dto, getSessionUser(req)));
//    }
//}
