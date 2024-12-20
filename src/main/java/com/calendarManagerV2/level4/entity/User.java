package com.calendarManagerV2.level4.entity;

import com.calendarManagerV2.level4.dto.requestdto.UserPostReqDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "user")
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;

    @Setter
    @Column(name = "username")
    private String username;

    @Setter
    @Column(name = "email", unique = true)
    private String email;

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

    @Override
    public void prePersist() {
        super.prePersist();
        userID = (userID == null) ? 1 : userID;
    }
}
