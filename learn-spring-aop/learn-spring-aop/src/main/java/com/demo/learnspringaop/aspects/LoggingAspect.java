package com.demo.learnspringaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("com.demo.learnspringaop.aspects.CommonAspectConfig.businessAndDataLogg()")
	public void logBeforeMethodCalls(JoinPoint joinPoint) {
		LOGGER.info("Before Aspect - Method Call Happen in {}", joinPoint);
	}

	@After("com.demo.learnspringaop.aspects.CommonAspectConfig.businessLoggPointcut()")
	public void logAfterMethodCalls(JoinPoint joinPoint) {
		LOGGER.info("After Aspect - Method Call {} is executed with arguments {}", joinPoint, joinPoint.getArgs());
	}

	@AfterThrowing(pointcut = "com.demo.learnspringaop.aspects.CommonAspectConfig.businessAndDataLogg()", throwing = "exception")
	public void logAfterThrowingException(JoinPoint joinPoint, Exception exception) {
		LOGGER.info("After throwing Aspect - Method {} is executed and throws {}", joinPoint, exception.toString());
	}

	@AfterReturning(pointcut = "com.demo.learnspringaop.aspects.CommonAspectConfig.businessAndDataLogg()", returning = "value")

	public void logAfterReturningInAMethod(JoinPoint joinPoint, Object value) {
		LOGGER.info("After Returning Aspect - Method {} is successfully executed and returns {}", joinPoint, value);
	}
	
}
