package com.calendarManagerV2.level8.aop;

import jakarta.persistence.EntityNotFoundException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

// 쿼리 결과가 null 또는 빈 컬렉션일 경우 ControllerAdvice가 처리하기 용이하도록
// 커스텀 예외를 던지는 AOP
//@Aspect
//@Component
public class CheckNoEntityAOP {
    @AfterReturning(
        pointcut = "execution(* org.springframework.data.jpa.repository.JpaRepository+.*(..))"
            + " && !execution(java.util.List org.springframework.data.jpa.repository.JpaRepository+.*(..))"
            + " && !execution(* org.springframework.data.jpa.repository.JpaRepository+.findFirstByEmail(..))"
            + " && !execution(* org.springframework.data.jpa.repository.JpaRepository+.delete*(..))",
        returning = "result"
    )
    public void checkNullFind(Object result) {
        if (result == null) throw new EntityNotFoundException("해당하는 값이 없습니다.");
    }

    @AfterReturning(
        pointcut = "execution(java.util.List org.springframework.data.jpa.repository.JpaRepository+.*(..))",
        returning = "resultList"
    )
    public void checkEmptyFindAll(List<?> resultList) {
        if (resultList.isEmpty()) {
            throw new EntityNotFoundException("해당하는 값이 없습니다.");
        }
    }
}
