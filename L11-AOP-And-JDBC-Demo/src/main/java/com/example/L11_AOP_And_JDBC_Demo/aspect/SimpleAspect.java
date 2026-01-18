package com.example.L11_AOP_And_JDBC_Demo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class SimpleAspect {
    private Logger LOGGER = LoggerFactory.getLogger(SimpleAspect.class);

//    @Before("execution(* com.example.L11_AOP_And_JDBC_Demo.service.ProductService.getById(..))")
//    public void beforeMethod(){
//        LOGGER.info("Before method called");
//    }
//
//    @Before("@annotation(com.example.L11_AOP_And_JDBC_Demo.aspect.LogExecutionTime)")
//    public void beforeAnnotation(){
//        LOGGER.info("Before annotation called");
//    }
//
//    @After("@annotation(com.example.L11_AOP_And_JDBC_Demo.aspect.LogExecutionTime)")
//    public void afterAnnotation(){
//        LOGGER.info("After annotation called");
//    }


    @Around("@annotation(com.example.L11_AOP_And_JDBC_Demo.aspect.LogExecutionTime)")
    public Object arroundAnnotationMethods(ProceedingJoinPoint joinPoint) throws Throwable{
        // start time
        long start = System.currentTimeMillis();
        //call actual method
        Object result = joinPoint.proceed();
        //end time
        long end = System.currentTimeMillis();

        LOGGER.info("Executing {} time: {}", joinPoint.getTarget(), end-start);
        return result;
    }

}
