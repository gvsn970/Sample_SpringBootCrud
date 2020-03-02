package com.nexiilabs.employee.springbootcrudwithhibernate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	private static final Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* com.nexiilabs.employee.springbootcrudwithhibernate.*.*.*(..))")
	public void loggingAop() {
		
	}
	@Around("loggingAop()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper omp=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
		String className=pjp.getTarget().getClass().toString();
		Object arry[]=pjp.getArgs();
		log.info("Method Invoked : "+className+" : "+ methodName+"() "+" Arguments :"+omp.writeValueAsString(arry));
		Object object=pjp.proceed();
		log.info(className+" : "+ methodName+"() " + " Response : "+omp.writeValueAsString(object));
		return object;
	}
	
	@AfterThrowing (pointcut = "execution(* com.nexiilabs.employee.springbootcrudwithhibernate.*.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable 
    {
        System.out.println("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
    }
}
