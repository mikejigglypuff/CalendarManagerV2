package com.calendarManagerV2.advanced_lv1and2.mvc.service;

import com.calendarManagerV2.advanced_lv1and2.config.PasswordEncoder;
import com.calendarManagerV2.advanced_lv1and2.dto.request.LoginReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.user.UserDeleteReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.user.UserGetReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.user.UserPatchReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.user.UserPostReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.response.mapper.ResponseFormatMapper;
import com.calendarManagerV2.advanced_lv1and2.dto.response.responseentity.UserResponseFormat;
import com.calendarManagerV2.advanced_lv1and2.entity.User;
import com.calendarManagerV2.advanced_lv1and2.mvc.repository.JpaUserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JpaUserRepositoryInterface repository;
    private final ResponseFormatMapper<UserResponseFormat, User> mapper;
    private final PasswordEncoder encoder;

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

        // 수정 요청을 보낸 회원 자신의 정보를 수정하는 것인지 확인
        if (user.equals(sessionUser)) user.setUserByPatchDTO(dto);
        return new UserResponseFormat(repository.save(user));
    }

    @Transactional(rollbackFor = {DataAccessException.class})
    public String deleteUser(UserDeleteReqDTO dto, User sessionUser) {
        User user = repository.findFirstByUserID(dto.getUserID());

        // 회원 자신을 탈퇴 처리하는 것인지 확인
        if (user.equals(sessionUser)) {
            repository.delete(user);
            return user.getUsername() + "님의 탈퇴가 완료되었습니다.";
        }

        return "사용자 삭제 실패";
    }

    public User loginUser(LoginReqDTO dto) {
        User user = repository.findFirstByEmail(dto.getEmail());

        // 암호화된 패스워드와 요청 패스워드 일치 확인
        if (!encoder.matches(dto.getPassword(), user.getPassword()))
            throw new NoSuchElementException("패스워드가 일치하지 않습니다.");

        return user;
    }
}
