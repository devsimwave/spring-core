package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.annotation.Pointcut;

public class StudentPointcut {
	
	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))") // 다른 advice에서 공통적으로 사용할 수 있도록 pointcut을 정의할 수 있다.
	public void studyPointcut() {}
}
