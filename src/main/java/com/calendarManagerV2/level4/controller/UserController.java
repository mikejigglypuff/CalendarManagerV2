/*
package com.calendarManagerV2.level4.controller;

import com.calendarManagerV2.level4.dto.requestdto.UserDeleteReqDTO;
import com.calendarManagerV2.level4.dto.requestdto.UserGetReqDTO;
import com.calendarManagerV2.level4.dto.requestdto.UserPatchReqDTO;
import com.calendarManagerV2.level4.dto.requestdto.UserPostReqDTO;
import com.calendarManagerV2.level4.dto.responsedto.UserDeleteResDTO;
import com.calendarManagerV2.level4.dto.responsedto.UserGetResDTO;
import com.calendarManagerV2.level4.dto.responsedto.UserPatchResDTO;
import com.calendarManagerV2.level4.dto.responsedto.UserPostResDTO;
import com.calendarManagerV2.level4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @GetMapping("/{userID}")
    public UserGetResDTO getUserByUserID(@PathVariable Long userID) {
        return new UserGetResDTO(service.findUserByUserID(new UserGetReqDTO(userID)));
    }

    @GetMapping
    public UserGetResDTO getAllUsers() {
        return new UserGetResDTO(service.findAllUsers());
    }

    @PostMapping
    public UserPostResDTO postUser(@RequestBody UserPostReqDTO dto) {
        return new UserPostResDTO(service.addUser(dto));
    }

    @PatchMapping
    public UserPatchResDTO patchUser(@RequestBody UserPatchReqDTO dto) {
        return new UserPatchResDTO(service.updateUser(dto));
    }

    @DeleteMapping
    public UserDeleteResDTO deleteUser(@ModelAttribute UserDeleteReqDTO dto) {
        return new UserDeleteResDTO(service.deleteUser(dto));
    }
}

 */
