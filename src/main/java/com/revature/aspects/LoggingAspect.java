package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value ="loggingAspect")
public class LoggingAspect {
	private static final Logger log = LogManager.getLogger(LoggingAspect.class);
	
	//Pointcut annotation, injecting code(advice) 
	@Pointcut("within(com.revature.controller.DoctorController)")
	public void doctorControllerLog() {}
	
	//Pointcut annotation, injecting code(advice) 
	@Pointcut("within(com.revature.controller.PatientController)")
	public void patientControllerLog() {}
	
	@After(value = "doctorControllerLog()")
	public void doctorContollerLogs(JoinPoint jp) {
	log.info(jp.getSignature().getName() + " was hit.");
	}
	
	@After(value = "patientControllerLog()")
	public void patientControllerLogs(JoinPoint jp) {
	log.info(jp.getSignature().getName() + " was hit.");
	}
}
