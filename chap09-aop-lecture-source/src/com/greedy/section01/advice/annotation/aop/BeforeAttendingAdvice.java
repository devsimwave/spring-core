package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.Passion;

@Component	// aop도 스프링에서 관리해야하기 때문에 bean으로 등록해줘야 한다.
@Aspect // adivce와 pointcut을 합친 개념을 Aspect라고 불린다.
public class BeforeAttendingAdvice {

	/* @Before, @After든 어노테이션이 붙은 메소드가 advice라고 한다.
	* before이면 before advice, after면 after advice라고 불린다. */
	@Before("execution(* com.greedy.section01.advice.annotation..*(..))") // pointcut 표현식 ..* 하위에 있는 모든 클래스와 메소드 (..) 매개변수 ..이 붙는다면 어떤 타입이든 다 포함된다라는 뜻
//	@Before("StudentPointcut.studyPointcut()")
	public void beforeAttending(JoinPoint joinPoint) {		// 해당 메소드가 호출되면 JoinPoint에 값이 들어가는데 대상 객체의 정보가 들어간다.
		System.out.println("================ before attending =================");
		System.out.println("오늘도 신나게 등원해서 입실 카드를 찍는다.");
		System.out.println("수강생 타입 : " + joinPoint.getTarget().getClass());	//타겟 클래스 정보
		System.out.println("수강생의 행위 : " + joinPoint.getSignature());			//리턴타입을 포함한 시그니처
		System.out.println("행위 요약 : " + joinPoint.getSignature().getName());
		System.out.println("수강생의 열정 : " + ((Passion) joinPoint.getArgs()[0]).getScore());	// 호출하는 메소드의 인자값을 배열 형태로 출력해준다.
		System.out.println("===================================================");
	}
}
