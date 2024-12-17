package com.calendarManagerV2.level8.entity;

import com.calendarManagerV2.level8.dto.requestdto.SchedulePostReqDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@NoArgsConstructor
@Getter
public class Schedule extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    public Schedule(SchedulePostReqDTO dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    @Override
    public void prePersist() {
        super.prePersist();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
