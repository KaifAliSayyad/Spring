package com.example.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JoinPointExample {
    @Before("execution(* com.example.aop.Employee.show(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        // Access method information
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method executed: " + signature.getName());
        
        // Access arguments
        Object[] args = joinPoint.getArgs();
        
        // Access target object
        Object target = joinPoint.getTarget();
        
        // Access proxy object
        Object proxy = joinPoint.getThis();

        System.out.println("Args -> "+args);
        System.out.println("Target -> "+target);
        System.out.println("Proxy -> "+proxy);
    }
}