package com.calendarManagerV2.advanced_lv1and2.entity;

import com.calendarManagerV2.advanced_lv1and2.dto.request.user.UserPatchReqDTO;
import com.calendarManagerV2.advanced_lv1and2.dto.request.user.UserPostReqDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;

    @Column(name = "username")
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Setter
    @Column(name = "password", unique = true)
    private String password;

    public User(long userID) {
        this.userID = userID;
    }

    public User(UserPostReqDTO dto) {
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }

    public void setUserByPatchDTO(UserPatchReqDTO dto) {
        String username = dto.getUsername();
        String email = dto.getEmail();

        if (username != null) this.username = username;
        if (email != null) this.email = email;
    }

    @Override
    public void prePersist() {
        super.prePersist();
        userID = (userID == null) ? 1 : userID;
    }

    // 세션의 값으로 저장되는 User 클래스의 동등성 비교를 위해 구현
    @Override
    public boolean equals(Object o) {
        if (o instanceof User comp) {
            return Objects.equals(this.userID, comp.getUserID()) && Objects.equals(this.username, comp.getUsername())
                && Objects.equals(this.email, comp.getEmail()) && Objects.equals(this.password, comp.getPassword())
                && Objects.equals(this.createdAt, comp.getCreatedAt());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID + username + email + password + createdAt);
    }
}
