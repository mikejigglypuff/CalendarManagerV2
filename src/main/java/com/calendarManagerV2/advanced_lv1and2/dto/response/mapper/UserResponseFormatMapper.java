package com.calendarManagerV2.advanced_lv1and2.dto.response.mapper;

import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.UserResponseFormat;
import com.calendarManagerV2.advanced_lv1and2.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResponseFormatMapper implements ResponseFormatMapper<UserResponseFormat, User> {

    @Override
    public List<UserResponseFormat> mapList(List<User> list) {
        return list.stream()
            .map(UserResponseFormat::new)
            .toList();
    }
}
