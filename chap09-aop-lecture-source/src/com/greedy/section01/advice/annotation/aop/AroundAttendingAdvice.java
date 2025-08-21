package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.annotation.GreedyStudent;

@Aspect
@Component
public class AroundAttendingAdvice {

	@Pointcut("execution(* com.greedy.section01.advice..*(..))")	// @Pointcut 어노테이션을 사용해서 포인트컷을 정의할 수 있다. 즉 이 어노테이션이 붙은 메소드는 포인트컷 표현식으로 사용될 수 있다.
	private void studentAroundPointcut() {} // 구현 내용이 없는 바디만 있는 메소드를 훅 메소드라고 한다.

	/* arouund advice는 가장 강력한 기능을 제공하는 advice다.
	* joinPoint는 사전 및 사후 부분을 장악하기 떄문에 가장 강력한 기능이다.*/
//	@Around("execution(* com.greedy.section01.advice.annotation..*(..))") // ProceedingJoinPoint는 JoinPoint하위 인터페이스이며 joinPoint를 제어할 수 있는 추가 기능이 있다. 진행 여부를 컨트롤 할 수 있는 joinPoint라고 생각하면 됨
	@Around("AroundAttendingAdvice.studentAroundPointcut()")	// @Pointcut 어노테이션이 붙은 메소드로 포인트컷 정의한 코드(같은 패키지면 클래스명 생략 가능)
	public Object arroundAttending(ProceedingJoinPoint joinPoint) throws Throwable {
//		throw new UnsupportedOperationException(); // 아직 작성되지 않은 메소드 사용했을 때 return null로 하면 예상치 못한 문제가 생길 수 있기 때문에 UnsupportedOperationException 예외를 던지면 코드 파악하기에 좋다.
		System.out.println("==================== around attending before ====================");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지!! 라는 마음으로 일찍 일어납니다.");
		System.out.println("=================================================================");

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		joinPoint.proceed();

		Object result = joinPoint.proceed();	// joinpoint의 메소드를 계속 실행하는 메소드

		System.out.println("======================= around attending after =====================");
		System.out.println("열심히 공부했으니 퇴실카드를 찍는다.");
		System.out.println("====================================================================");

		if(joinPoint.getTarget() instanceof GreedyStudent) {
			System.out.println("수업이 끝나도 끝난게 아닙니다. 자율적 스터디 그룹과 함께 다시 공부합니다!!");
		}

		stopWatch.stop();

		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		System.out.println("====================================================================");

		return result;
	}

}









