package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    
    public void show(){
        System.out.println("from Employee.show method...");
        System.out.println("show method");
        System.out.println("Finished Employee.show method...");
    }
}
