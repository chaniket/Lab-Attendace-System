package com.cb.aop;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	static Logger logger = Logger.getLogger(LoggingAspect.class.getClass().getName());

	public void logBeforeAllMethods(JoinPoint jp) throws Throwable {
		logger.info("****LoggingAspect.logBeforeAllMethods() " + jp.getSignature().getName() + "\t"
				+ Arrays.toString(jp.getArgs()));
		System.out.println("****LoggingAspect.logBeforeAllMethods() " + jp.getSignature().getName() + "\t"
				+ Arrays.toString(jp.getArgs()));
	}

	public void logAfterReturingAllMethods(Object retVal) throws Throwable {
		System.out.println("****LoggingAspect.logAfterReturingAllMethods() " + retVal);
	}

	public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
		System.out.println("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
	}

	public void logAfterAllMethods(JoinPoint jp) throws Throwable {
		System.out.println("****LoggingAspect.logAfterAllMethods() " + jp.getSignature().getName());
	}

	public Object logAroundAllMethods(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("****LoggingAspect.logAroundAllMethods() - Before method call "+pjp.getSignature()+"\texecutio started.");
		Object ratVal=pjp.proceed();
		logger.info(ratVal+" ****LoggingAspect.logAroundAllMethods() - After method call "+pjp.getSignature()+"\texecution completed.");
		//System.out.println("****LoggingAspect.logAroundAllMethods() - After method call");
		return ratVal;
	}


}
