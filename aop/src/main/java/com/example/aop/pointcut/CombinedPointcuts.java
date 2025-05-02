package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CombinedPointcuts {
    // AND
    @Before("execution(* com.example.aop.*.*(..)) && args(String)")
    public void beforeStringMethodInPackage() { }
    
    // OR
    @Before("execution(* com.example.aop.Employee.*(..)) || execution(* com.example.aop.Manager.*(..))")
    public void beforeEmployeeOrManagerMethod() { }
    
    // NOT
    @Before("execution(* com.example.aop.*.*(..)) && !execution(* com.example.aop.*.get*(..))")
    public void beforeNonGetterMethod() { }
}