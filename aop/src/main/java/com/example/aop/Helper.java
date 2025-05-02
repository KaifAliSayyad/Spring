package com.example.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper{

    @Before("execution(* com.example.aop.Employee.show(..))")
    public void helperMethod(JoinPoint jp){
        System.out.println("From aspect before...");
        Method method = (Method) ((MethodSignature) jp.getSignature()).getMethod();
        System.out.println(method.getName());
        System.out.println("Finished aspect Before...");
    }

    @Around("execution(* com.example.aop.Employee.show(..))")
    public void helperMethod2(ProceedingJoinPoint pjp) throws Throwable{

        System.out.println("from aspect After....");
        System.out.println("before running the main method...");
        pjp.proceed();
        System.out.println("from aspect After....");
        System.out.println("after running the main method...");
        System.out.println("finished aspect After...");
    }

    
}