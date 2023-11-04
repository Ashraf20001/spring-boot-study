package com.demo.learnspringaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);
	
//	@Around(value = "com.demo.learnspringaop.aspects.CommonAspectConfig.allBeanAspectPointcut()")
	@Around(value = "com.demo.learnspringaop.aspects.CommonAspectConfig.timeTrackAnnotation()")
	public Object logPerformaceForMethods(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
		// Start Timer
		long startTime = System.currentTimeMillis();
		
		//Execute method
		Object returnValue = proceedJoinPoint.proceed();
		
		// End Timer
		long endTime = System.currentTimeMillis();
		
		long performanceTime=endTime - startTime;
		
		LOGGER.info("Around Aspect - Method {} executed in performance time of {} ",proceedJoinPoint,performanceTime);
		
		return returnValue;
	}
}
