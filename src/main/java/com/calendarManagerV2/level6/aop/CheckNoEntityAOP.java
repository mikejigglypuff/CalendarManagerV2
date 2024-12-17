package com.calendarManagerV2.level6.aop;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Slf4j
public class CheckNoEntityAOP {
    @AfterReturning(
        pointcut = "execution(* org.springframework.data.jpa.repository.JpaRepository+.*(..))"
            + " && !execution(java.util.List org.springframework.data.jpa.repository.JpaRepository+.*(..))"
            + " && !execution(* org.springframework.data.jpa.repository.JpaRepository+.findFirstByEmail(..))",
        returning = "result"
    )
    public void checkNullFind(Object result) {
        if(result == null) throw new EntityNotFoundException("해당하는 값이 없습니다.");
    }

    @AfterReturning(
        pointcut = "execution(java.util.List org.springframework.data.jpa.repository.JpaRepository+.*(..))",
        returning = "resultList"
    )
    public void checkEmptyFindAll(List<?> resultList) {
        if(resultList.isEmpty()) throw new EntityNotFoundException("해당하는 값이 없습니다.");
    }
}
