package com.ids.support.aop;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${service.error.timeout: 10000}")
	private int serviceErrorTimeout;
	@Value("${service.warn.timeout: 3000}")
	private int serviceWarnTimeout;
	
	public LogAspect() {
		System.out.println("constr " + serviceErrorTimeout);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init " + serviceErrorTimeout);
	}
	
	@Pointcut("@within(org.springframework.stereotype.Service)")
	public void withServiceAnnotation() {}
	@Pointcut("execution(public * com.ids.service..*Service.*(..))")
	public void serviceMethods() {}
	
	@Pointcut("serviceMethods() || withServiceAnnotation()")
	public void allServiceMethods() {}
	
	@Around("allServiceMethods()")
	public Object logAndTimeExecution(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());
		String methodName = pjp.getSignature().getName();
		try {
			//@Before
			log.debug("Appel de la methode : {}", methodName);
			log.debug("Parametres : {}", Arrays.toString(pjp.getArgs()));
			Object retval = pjp.proceed();
			//@AfterReturning
			log.trace("Résultat : {}", retval);
			return retval;
		} catch(RuntimeException e) {
			//@AfterThrowing
			log.warn("Erreur execution de la méthode {} - {}", methodName, e.getMessage());
			throw e;
		} catch (Throwable e) {
			//@AfterThrowing
			log.error("Erreur execution de la méthode {} - {}", methodName, e.getMessage());
			throw e;
		} finally {
			//@After
			long time = System.currentTimeMillis() - start;
			log.debug("Temps exécution : {} ms", time);
			if (time > serviceErrorTimeout) {
				log.error("le service {} a depassé {} ms", methodName, serviceErrorTimeout);
			} else if (time > serviceWarnTimeout) {
				log.warn("le service {} a depassé {} ms", methodName, serviceWarnTimeout);
			}
		}
	} 

//	@Before("execution(public * com.ids.service..*Service.*(..))")
//	public void log(JoinPoint joinPoint) {
//		log.trace("execution - Appel de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("execution - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//	}

//	@Before("within(com.ids.service.facture.IFactureService)")
//	public void logWithin(JoinPoint joinPoint) {
//		log.trace("within - Appel de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("within - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//	}
//	@Before("target(com.ids.service.facture.IFactureService)")
//	public void logTarget(JoinPoint joinPoint) {
//		log.trace("target - Appel de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("target - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//	}

//	@Before("@annotation(org.springframework.transaction.annotation.Transactional)")
//	public void methodWithAnnotation(JoinPoint joinPoint) {
//		log.trace("method annotation - Appel de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("method annotation - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//	}
//	
//	@Before("serviceMethods()")
//	public void classWithAnnotation(JoinPoint joinPoint) {
//		log.trace("class annotation - Appel de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("class annotation - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//	}
//	
//	@Before("@within(com.ids.support.aop.Supervision) || @annotation(com.ids.support.aop.Supervision)")
//	public void supervision(JoinPoint joinPoint) {
//		log.trace("supervision - Appel de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("supervision - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//	}
////	@AfterReturning("@within(com.ids.support.aop.Supervision) || @annotation(com.ids.support.aop.Supervision)")
//	@AfterReturning(value = "serviceMethods()", returning = "result")
//	public void afterReturning(JoinPoint joinPoint, Object result) {
//		log.trace("after returning - resultat de la methode : {}", joinPoint.getSignature().toShortString());
//		log.trace("supervision - Parametres : {}", Arrays.toString(joinPoint.getArgs()));
//		log.debug("resultat : {}", result);
//	}
//	
//	@AfterThrowing(pointcut = "serviceMethods()", throwing = "e")
//	public void log(JoinPoint joinPoint, Throwable e) {
//		log.error("Retour de la methode {} avec une exception {}", joinPoint.getSignature().toShortString(), e.getClass().getSimpleName());
//	}
//	
}