package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.AchievementResult;

@Aspect
@Component
public class AfterReturningAttendingAdvice {

    /*@AfterReturning adivce가 동작했을 때 target object 메소드의 정보를 joinPoint로 받으며 return값은 Object타입으로 받는다. @After보다 먼저 실행된다.*/

    @AfterReturning(pointcut="execution(* com.greedy.section01.advice.annotation..*(..))", returning="result")  //pointcut 설정이 한가지 이상이라면 pointcut을 명시해줘야 한다. execution(* com.greedy.section01.advice.annotation..*(..))" 이렇게 pointcut 속성만 작성 불가
    public void afterReturningAttending(JoinPoint joinPoint, Object result) {   // target ojbect를 확인하는 joinpoint는 첫번째 매개변수로 작성해줘야 하며 두번째 매개변수는 메소드 호출했을 때 리턴 결과를 Object타입으로 받는다.returning에 설저앻ㅆ던 값과 변수명이 같아야 한다.

        System.out.println("============== after returning attending ==============");
        System.out.println("보람찬! 하루일을! 끝마치고서~~ 두 다리 쭉펴면 고향의 안방~~!!");
        System.out.println("오늘의 이해도 : " + ((AchievementResult) result).getUnderstandingScore() );
        System.out.println("오늘의 이해도 : " + ((AchievementResult) result).getSatisfactionScore() );
        double employeementRate = ((AchievementResult) result).getEmployeementRate();
        double percent = employeementRate / 1000.0 * 100;
        System.out.println("증가된 취업율 : " + percent + "%");

        ((AchievementResult) result).setEmployeementRate(percent);  // 리턴값을 변경할 목적으로도 @AfterReturning advice를 사용하기도 한다.
        System.out.println("========================================================");

    }
}







