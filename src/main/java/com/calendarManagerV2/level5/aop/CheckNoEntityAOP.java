package com.calendarManagerV2.level5.aop;

import com.calendarManagerV2.level5.entity.Schedule;
import com.calendarManagerV2.level5.entity.User;
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
            + " && !execution(* org.springframework.data.jpa.repository.JpaRepository+.findAll(..))",
        returning = "result"
    )
    public void checkNullFind(Object result) {
        if(result == null) throw new EntityNotFoundException("해당하는 값이 없습니다.");
    }

    @AfterReturning(
        pointcut = "execution(* org.springframework.data.jpa.repository.JpaRepository+.findAll(..))",
        returning = "result"
    )
    public void checkEmptyFindAll(List<Object> result) {
        if(result.isEmpty()) throw new EntityNotFoundException("해당하는 값이 없습니다.");
    }
}
