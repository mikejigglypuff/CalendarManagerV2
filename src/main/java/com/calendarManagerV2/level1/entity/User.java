/*
package com.calendarManagerV2.level1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "userID")
    private long userID;

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
}

 */
