package com.Saumya.spring_bbot_rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//FIrst of all we will add annotation Cimponent so we will tell the spring to manage the Beancom

@Component
@Aspect
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* com.Saumya.spring_bbot_rest.service.JobService.getAllJobs(..))")
    public Object  monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();
         Object obj = jp.proceed();


        long end = System.currentTimeMillis();

        LOGGER.info("Time taken : " + jp.getSignature().getName() + ":" + (end-start));

        return obj;
    }
}
