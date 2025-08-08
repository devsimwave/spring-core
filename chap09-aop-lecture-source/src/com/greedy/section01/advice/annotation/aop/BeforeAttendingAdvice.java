package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.Passion;

@Component
@Aspect
public class BeforeAttendingAdvice {
	
//	@Before("execution(* com.greedy.section01.advice.annotation..*(..))")
	@Before("StudentPointcut.studyPointcut()")
	public void beforeAttending(JoinPoint joinPoint) {
		System.out.println("================ before attending =================");
		System.out.println("오늘도 신나게 등원해서 입실 카드를 찍는다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass());	//타겟 클래스 정보
		System.out.println("수강생의 행위 : " + joinPoint.getSignature());			//리턴타입을 포함한 시그니처
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());
		System.out.println("수강생의 열정 : " + ((Passion) joinPoint.getArgs()[0]).getScore());
		System.out.println("===================================================");
	}
}
