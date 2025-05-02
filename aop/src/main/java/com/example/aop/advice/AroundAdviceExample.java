package com.example.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAdviceExample {
    @Around("execution(* com.example.aop.Employee.show(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Before method execution");
        
        // Control whether to proceed with the method execution
        Object result = pjp.proceed();
        // Or with modified arguments: pjp.proceed(new Object[] { modifiedArg });
        
        System.out.println("After method execution");
        return result;
    }
}