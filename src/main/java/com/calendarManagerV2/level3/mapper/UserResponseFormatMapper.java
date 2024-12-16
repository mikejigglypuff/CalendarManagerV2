package com.calendarManagerV2.level3.mapper;

import com.calendarManagerV2.level3.dto.responsedto.responseentity.UserResponseFormat;
import com.calendarManagerV2.level3.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component("userMapper")
public class UserResponseFormatMapper implements ResponseFormatMapper<UserResponseFormat, User> {

    @Override
    public List<UserResponseFormat> mapList(List<User> list) {
        return list.stream()
            .map(UserResponseFormat::new)
            .toList();
    }
}
