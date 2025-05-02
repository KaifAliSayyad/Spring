package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WithinExample {
    // Match any method in Employee class
    @Before("within(com.example.aop.Employee)")
    public void beforeAnyMethodInEmployee() { }
    
    // Match any method in the package
    @Before("within(com.example.aop.*)")
    public void beforeAnyMethodInPackage() { }
}