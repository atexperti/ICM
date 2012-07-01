package org.icm.facade;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	
	public static Logger logger = Logger.getLogger(LoggingAspect.class);

	@Around("execution(* org.icm.facade.*.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		//logger.info("Around advice before joinpoint");
		Object obj = pjp.proceed();

		//logger.info("Around advice after running");
		return obj;
	}

	@AfterThrowing(pointcut = "execution(* org.icm.facade.*.*(..))", throwing = "error")
	public void logAfterThrowingFacade(JoinPoint joinPoint, Throwable error) {
		
			logger.error(error +" IN " + joinPoint.getSignature().toLongString() );
		
		}
	@AfterThrowing(pointcut = "execution(* org.icm.dao.*.*(..))", throwing = "error")
	public void logAfterThrowingDao(JoinPoint joinPoint, Throwable error) {
		
			logger.error(error +" IN " + joinPoint.getSignature().toLongString() );
		
		}
	/*
	@AfterThrowing(pointcut = "execution(* com.valuelabs.momac.action.*.*(..))", throwing = "error")
	public void logAfterThrowingAction(JoinPoint joinPoint, Throwable error) {
		
			logger.error(error +" IN " + joinPoint.getSignature().toLongString() );
		
		}
*/
}