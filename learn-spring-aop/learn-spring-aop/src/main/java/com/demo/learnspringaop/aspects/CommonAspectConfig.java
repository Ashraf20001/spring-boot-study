package com.demo.learnspringaop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonAspectConfig {

	@Pointcut("(execution(* com.demo.learnspringaop.*.*.*(..)))")
	public void businessAndDataLogg() {}
	
	@Pointcut("(execution(* com.demo.learnspringaop.business.*.*(..)))")
	public void businessLoggPointcut() {}
	
	@Pointcut("(execution(* com.demo.learnspringaop.datalayer.*.*(..)))")
	public void dataLoggPointcut() {}
	
	@Pointcut("bean(*Layer*)")
	public void allBeanAspectPointcut() {}
	
	@Pointcut("@annotation(com.demo.learnspringaop.business.TimeTrack)")
	public void timeTrackAnnotation() {}
	
	
	
}
