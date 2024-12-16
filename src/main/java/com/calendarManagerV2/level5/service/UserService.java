package com.calendarManagerV2.level5.service;

import com.calendarManagerV2.level5.dto.requestdto.*;
import com.calendarManagerV2.level5.dto.responsedto.responseentity.UserResponseFormat;
import com.calendarManagerV2.level5.entity.User;
import com.calendarManagerV2.level5.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level5.repository.JpaUserRepositoryInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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

    @Transactional(rollbackFor = {DataAccessException.class})
    public UserResponseFormat findUserByUserID(UserGetReqDTO dto) {
        return new UserResponseFormat(repository.findFirstByUserID(dto.getUserID()));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public List<UserResponseFormat> findAllUsers() {
        return mapper.mapList(repository.findAll());
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public UserResponseFormat addUser(UserPostReqDTO dto) {
        return new UserResponseFormat(repository.save(new User(dto)));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public UserResponseFormat updateUser(UserPatchReqDTO dto, User sessionUser) {
        User user = repository.findFirstByEmail(dto.getEmail());

        if(user.equals(sessionUser)) {
            String username = dto.getUsername();
            String email = dto.getEmail();

            if(username != null) user.setUsername(username);
            if(email != null) user.setEmail(email);
        }
        return new UserResponseFormat(repository.save(user));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteUser(UserDeleteReqDTO dto, User sessionUser) {
        User user = repository.findFirstByUserID(dto.getUserID());

        if(user.equals(sessionUser)) {
            repository.delete(user);
            return user.getUsername();
        }

        return "사용자 삭제 실패";
    }

    public User loginUser(LoginReqDTO dto) {
        User user = repository.findFirstByEmailAndPassword(dto.getEmail(), dto.getPassword());

        // aop로 분리할 것
        if(user == null) throw new NoSuchElementException("이메일 또는 패스워드가 틀렸습니다.");

        return user;
    }
}
