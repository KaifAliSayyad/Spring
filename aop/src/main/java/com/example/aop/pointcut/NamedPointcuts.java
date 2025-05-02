package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NamedPointcuts {
    // Define reusable pointcut
    @Pointcut("execution(* com.example.aop.Employee.*(..))")
    private void employeeMethods() {}
    
    @Pointcut("execution(* *.get*(..))")
    private void getterMethods() {}
    
    // Combine named pointcuts
    @Before("employeeMethods() && !getterMethods()")
    public void beforeNonGetterEmployeeMethods() { }
}