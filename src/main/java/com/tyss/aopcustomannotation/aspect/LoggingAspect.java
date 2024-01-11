package com.tyss.aopcustomannotation.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("@annotation(logging)")
    public void beforeLogging(JoinPoint joinPoint, Logging logging) {
        System.out.println("Before method is invoked for " + joinPoint.getSignature().getName());
    }

    @After("@annotation(logging)")
    public void afterLogging(JoinPoint joinPoint, Logging logging) {
        System.out.println("After method is invoked for " + joinPoint.getSignature().getName());
    }

//    @AfterReturning(value = "@annotation(logging)",returning = "employee")
//    public Employee afterReturningLogging(JoinPoint joinPoint,Employee employee,Logging logging) {
//        System.out.println(joinPoint.getSignature());
//        System.out.println("Data returned is "+employee);
//        return employee;
//    }
}
