package com.skor.employees.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.skor.employees.controller.*.*(..))")
    public void beforeAllMethodsLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("---executing " + joinPoint.getSignature().getName() + " method---");
    }
}
