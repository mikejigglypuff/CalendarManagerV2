package com.calendarManagerV2.level6.entity;

import com.calendarManagerV2.level6.dto.requestdto.UserPostReqDTO;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long userID;

    @Setter
    @Column(name = "username")
    private String username;

    @Setter
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

    @Override
    public void prePersist() {
        super.prePersist();
        userID = (userID == null) ? 1 : userID;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof User comp) {
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
