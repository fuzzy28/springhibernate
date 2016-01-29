package org.jrue.poc.springconfig;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class LoggingAspect {

	static Logger logger = org.slf4j.LoggerFactory.getLogger(Logger.class);
	
	@Around("execution(* org.jrue.poc.springhibernate.service.UserServiceImpl.save(..))")
	public void savePointCut(ProceedingJoinPoint point) throws Throwable {
		logger.debug("Executing " + point.getSignature());
		point.proceed();
		logger.debug("Executed " + point.getSignature());
	}
		
}