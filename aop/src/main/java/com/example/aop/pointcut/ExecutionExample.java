package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionExample {
    // Match any method in Employee class
    @Before("execution(* com.example.aop.Employee.*(..))")
    public void beforeAnyMethod() { }
    
    // Match specific return type and parameters
    @Before("execution(String com.example.aop.Employee.getName(int))")
    public void beforeGetName() { }
    
    // Match with wildcards
    @Before("execution(* com.example.aop.*.*(..))") 
    public void beforeAnyMethodInPackage() { }
}