package com.Saumya.spring_bbot_rest.aop;

import com.Saumya.spring_bbot_rest.service.JobService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class JObAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(JObAspect.class);
    //return type , // fully qualified class Name, //method name, //argument
    @Before("execution(* com.Saumya.spring_bbot_rest.service.JobService.getAllJobs(..)) ")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method Called.. "+jp.getSignature().getName());
    }

    @After("execution(* com.Saumya.spring_bbot_rest.service.JobService.getAllJobs(..)) ")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed..."+jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.Saumya.spring_bbot_rest.service.JobService.getAllJobs(..)) ")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method Executed... "+jp.getSignature().getName());
    }
}
