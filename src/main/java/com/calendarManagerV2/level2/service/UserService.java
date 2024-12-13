package com.calendarManagerV2.level2.service;

import com.calendarManagerV2.level2.dto.requestdto.UserDeleteReqDTO;
import com.calendarManagerV2.level2.dto.requestdto.UserGetReqDTO;
import com.calendarManagerV2.level2.dto.requestdto.UserPatchReqDTO;
import com.calendarManagerV2.level2.dto.requestdto.UserPostReqDTO;
import com.calendarManagerV2.level2.dto.responsedto.responseentity.UserResponseFormat;
import com.calendarManagerV2.level2.entity.Schedule;
import com.calendarManagerV2.level2.entity.User;
import com.calendarManagerV2.level2.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level2.repository.JpaUserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final JpaUserRepositoryInterface repository;
    private final ResponseFormatMapper<UserResponseFormat, User> mapper;

    public UserService(
        JpaUserRepositoryInterface repository,
        @Qualifier("userMapper") ResponseFormatMapper<UserResponseFormat, User> mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserResponseFormat findUserByUserID(UserGetReqDTO dto) {
        return new UserResponseFormat(repository.findFirstByUserID(dto.getUserID()));
    }

    public List<UserResponseFormat> findAllUsers() {
        return mapper.mapList(repository.findAll());
    }

    public UserResponseFormat addUser(UserPostReqDTO dto) {
        return new UserResponseFormat(repository.save(new User(dto)));
    }

    public UserResponseFormat updateUser(UserPatchReqDTO dto) {
        User user = repository.findFirstByEmail(dto.getEmail());

        if(user.getPassword().equals(dto.getPassword())) {
            String username = dto.getUsername();
            String email = dto.getEmail();

            if(username != null) user.setUsername(username);
            if(email != null) user.setEmail(email);
        }
        return new UserResponseFormat(repository.save(user));
    }

    public String deleteUser(UserDeleteReqDTO dto) {
        User user = repository.findFirstByUserID(dto.getUserID());

        if(user.getPassword().equals(dto.getPassword())) {
            repository.delete(user);
            return user.getUsername();
        }

        return "사용자 삭제 실패";
    }
}
