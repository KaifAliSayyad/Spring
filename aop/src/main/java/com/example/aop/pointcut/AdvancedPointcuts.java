package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdvancedPointcuts {
    // Match when target object is Employee
    @Before("target(com.example.aop.Employee)")
    public void beforeEmployeeMethod() { }
    
    // Match when proxy implements interface
    @Before("this(com.example.aop.EmployeeInterface)")
    public void beforeProxyMethod() { }
    

    //This was not working because this pointcut was referring to java's internal class which may be final and which cannot be proxied
    // // Match based on arguments
    // @Before("args(java.lang.String, ..)")
    // public void beforeMethodWithStringArg() { }
}