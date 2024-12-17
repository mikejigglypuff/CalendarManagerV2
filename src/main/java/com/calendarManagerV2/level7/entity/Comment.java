package com.calendarManagerV2.level7.entity;

import com.calendarManagerV2.level7.dto.requestdto.CommentPostReqDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@NoArgsConstructor
@Getter
public class Comment extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private long commentID;

    @Setter
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "scheduleID")
    private Schedule schedule;

    @Setter
    @Column(name = "content")
    private String content;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    public Comment(CommentPostReqDTO dto) {

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
