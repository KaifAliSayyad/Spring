package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AnnotationExample {
    // Match methods with @Loggable annotation
    @Before("@annotation(com.example.aop.annotation.Loggable)")
    public void beforeLoggableMethod() { }
}