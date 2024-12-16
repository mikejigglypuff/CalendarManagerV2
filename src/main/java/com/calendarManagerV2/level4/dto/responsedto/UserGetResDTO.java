package com.calendarManagerV2.level4.dto.responsedto;

import com.calendarManagerV2.level4.dto.responsedto.responseentity.UserResponseFormat;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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
