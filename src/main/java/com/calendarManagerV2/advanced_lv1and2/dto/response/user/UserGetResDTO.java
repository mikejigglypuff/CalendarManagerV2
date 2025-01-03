package com.calendarManagerV2.advanced_lv1and2.dto.response.user;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.UserResponseFormat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// 단일 조회 및 여러 건 조회에 모두 쓰일 수 있도록 한 Response DTO
@Getter
public class UserGetResDTO {
    private final String message;
    private final List<UserResponseFormat> userFormatList;

    public UserGetResDTO(List<UserResponseFormat> userFormatList) {
        this.userFormatList = userFormatList;
        this.message = userFormatList.size() + "명의 사용자를 조회했습니다.";
    }

    public UserGetResDTO(UserResponseFormat userFormat) {
        this.userFormatList = new ArrayList<>();
        userFormatList.add(userFormat);
        this.message = "1명의 사용자를 조회했습니다.";
    }
}
