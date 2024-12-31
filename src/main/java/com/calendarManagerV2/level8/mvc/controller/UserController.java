//package com.calendarManagerV2.level8.mvc.controller;
//
//import com.calendarManagerV2.level8.annotation.IDValidation;
//import com.calendarManagerV2.level8.dto.requestdto.UserDeleteReqDTO;
//import com.calendarManagerV2.level8.dto.requestdto.UserGetReqDTO;
//import com.calendarManagerV2.level8.dto.requestdto.UserPatchReqDTO;
//import com.calendarManagerV2.level8.dto.requestdto.UserPostReqDTO;
//import com.calendarManagerV2.level8.dto.responsedto.UserDeleteResDTO;
//import com.calendarManagerV2.level8.dto.responsedto.UserGetResDTO;
//import com.calendarManagerV2.level8.dto.responsedto.UserPatchResDTO;
//import com.calendarManagerV2.level8.dto.responsedto.UserPostResDTO;
//import com.calendarManagerV2.level8.mvc.service.UserService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "/api/user")
//@RequiredArgsConstructor
//@Tag(name = "유저 API", description = "유저 CRUD API, POST를 제외한 메서드로 접근 시 로그인 필요")
//public class UserController extends AbstractController {
//    private final UserService service;
//
//    @Operation(summary = "유저 식별자로 유저 조회", description = "로그인 시 사용하는 이메일과 관계 없음")
//    @GetMapping("/{userID}")
//    public UserGetResDTO getUserByUserID(@Valid @IDValidation @PathVariable Long userID) {
//        return new UserGetResDTO(service.findUserByUserID(new UserGetReqDTO(userID)));
//    }
//
//    @Operation(summary = "전체 유저 조회")
//    @GetMapping
//    public UserGetResDTO getAllUsers() {
//        return new UserGetResDTO(service.findAllUsers());
//    }
//
//    @Operation(summary = "유저 등록", description = "로그인하지 않고 사용 가능")
//    @PostMapping
//    public UserPostResDTO postUser(@Valid @RequestBody UserPostReqDTO dto) {
//        return new UserPostResDTO(service.addUser(dto));
//    }
//
//    @Operation(summary = "유저 정보 수정", description = "유저 이름 및 이메일 수정 가능")
//    @PatchMapping
//    public UserPatchResDTO patchUser(@Valid @RequestBody UserPatchReqDTO dto, HttpServletRequest req) {
//        return new UserPatchResDTO(service.updateUser(dto, getSessionUser(req)));
//    }
//
//    @Operation(summary = "유저 삭제")
//    @DeleteMapping
//    public UserDeleteResDTO deleteUser(@Valid @ModelAttribute UserDeleteReqDTO dto, HttpServletRequest req) {
//        return new UserDeleteResDTO(service.deleteUser(dto, getSessionUser(req)));
//    }
//}
