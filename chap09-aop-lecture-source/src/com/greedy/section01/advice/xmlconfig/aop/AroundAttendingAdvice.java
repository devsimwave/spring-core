package com.greedy.section01.advice.xmlconfig.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.xmlconfig.GreedyStudent;

public class AroundAttendingAdvice {
	
	public Object aroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("=============== around attending before ================");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지!! 라는 마음으로 일찍 일어납니다.");
		System.out.println("========================================================");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = joinPoint.proceed();
		
		System.out.println("============== around attending after ==================");
		System.out.println("열심히 공부했으니 퇴실카드를 찍는다.");
		
		if(joinPoint.getTarget() instanceof GreedyStudent) {
			System.out.println("수업이 끝나도 끝난게 아닙니다. 자율적 스터디 그룹과 함께 다시 공부합니다!!");
		}
		
		stopWatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("========================================================");
		
		
		
		return result;
	}
}









