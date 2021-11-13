//package com.ids.support.aop;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class LoggingAspect {
//
//    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class.getName());
//
//    @Pointcut("@target(org.springframework.stereotype.Service)")
//    public void repositoryMethods() {};
//
//    @Before("repositoryMethods()")
//    public void logMethodCall(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//        logger.trace("Before " + methodName);
//    }
//}