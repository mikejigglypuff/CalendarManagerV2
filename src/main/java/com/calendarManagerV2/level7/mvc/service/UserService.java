package com.calendarManagerV2.level7.mvc.service;

import com.calendarManagerV2.level7.config.PasswordEncoder;
import com.calendarManagerV2.level7.dto.requestdto.*;
import com.calendarManagerV2.level7.dto.responsedto.responseentity.UserResponseFormat;
import com.calendarManagerV2.level7.entity.User;
import com.calendarManagerV2.level7.dto.responsedto.mapper.ResponseFormatMapper;
import com.calendarManagerV2.level7.mvc.repository.JpaUserRepositoryInterface;
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
    private final PasswordEncoder encoder;

    public UserService(
        JpaUserRepositoryInterface repository,
        @Qualifier("userMapper") ResponseFormatMapper<UserResponseFormat, User> mapper,
        PasswordEncoder encoder
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
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
        User user = new User(dto);
        user.setPassword(encoder.encode(dto.getPassword()));
        return new UserResponseFormat(repository.save(user));
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
            return user.getUsername() + "님의 탈퇴가 완료되었습니다.";
        }

        return "사용자 삭제 실패";
    }

    public User loginUser(LoginReqDTO dto) {
        User user = repository.findFirstByEmail(dto.getEmail());

        // aop로 분리할 것
        if(user == null) throw new NoSuchElementException("존재하지 않는 이메일입니다.");
        if(!encoder.matches(dto.getPassword(), user.getPassword()))
            throw new NoSuchElementException("패스워드가 일치하지 않습니다.");

        return user;
    }
}
