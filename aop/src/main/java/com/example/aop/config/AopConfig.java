package com.example.aop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = false) // Use JDK dynamic proxies instead of CGLIB
public class AopConfig {
    // Configuration beans
}