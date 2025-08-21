package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAttendingAdvice {

	/*@AfterThrowing exception이 발생할 때만 나오는 adivce 주로 오류 로그를 남기기 위해서 사용한다.
	* @AfterThrowing이 발생한다면 @AfterReturning 발생하지 않으며 반대인 경우는 @afterThrowing이 발생하지 않는다.
	* 하지만 @after는 그와 별개로 실행이 된다. */

	@AfterThrowing(pointcut="execution(* com.greedy.section01.advice.annotation..*(..))", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Throwable exception) {
		System.out.println("================= after throwing attending  =================");
		System.out.println(exception.getMessage());
		System.out.println("=============================================================");

	}
}
