package com.calendarManagerV2.level1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@NoArgsConstructor
@Getter
public class Schedule {
    @Id @GeneratedValue
    @Column(name = "scheduleID")
    private long scheduleID;

    @Setter
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @Setter
    @Column(name = "title")
    private String title;

    @Setter
    @Column(name = "content")
    private String content;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "updatedAt")
    private String updatedAt;
}
