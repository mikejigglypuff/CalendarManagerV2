package com.calendarManagerV2.level8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

// 엔티티들에 공통으로 적용되는 필드 및 Auditing이 구현된 상위 엔티티 클래스
@Getter
@RequiredArgsConstructor
//@MappedSuperclass
public class BaseEntity {
    @Column(name = "createdAt", updatable = false)
    protected LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
