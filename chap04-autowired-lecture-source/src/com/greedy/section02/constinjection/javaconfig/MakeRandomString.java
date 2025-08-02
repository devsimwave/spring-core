package com.greedy.section02.constinjection.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {
	
	private final RandomGenerator random;
	
//	public MakeRandomString() {}
	
	/* 생성자 주입의 장점
	 * 1. 필드 주입이 간단하긴 하지만 단일 책임의 원칙 관점에서 볼 때 필드는 수 많은 빈들을 주입받는 경우 만능 클래스가 될 수 있다.
	 *    따라서 필드주입을 하게 되면 너무 많은 역할을 하는 객체가 탄생할 수 있기 때문에 생성자 주입을 권장한다.
	 *    생성자 주입을 하게 되면 생성자의 매개변수가 많아지면서 이게 아닌데 라는 느낌을 받고 리팩토링을 할 수 있는 지표가 될 수 있다.
	 * 2. 필드에 final 키워드 사용이 가능해진다. 따라서 변경 불가능한 속성을 가질 수 있다는 장점을 가진다.
	 * 3. 순환참조 방지 (필드 주입이나 세터 주입의 경우 메소드 실행 시점에만 순환참조여부를 확인할 수 있지만, 
	 *    생성자 주입을 사용하면 애플리케이션 실행 시점에 확인 가능하다.)
	 *    예를 들어 특정 메소드를 이용할 때 순환참조가 발생하는 오류가 생긴다면 테스트 시 지나가는 경우 그 오류를 확인할 수 없지만
	 *    생성자 주입을 이용하는 경우 애플리케이션에 시동을 거는 시점에 오류가 발생하기 때문에 사전에 오류를 방지할 수 있다.
	 * 4. DI 컨테이너와 결합도가 낮기 때문에 테스트 하기 좋다. (스프링 컨테이너 없이 테스트를 할 수 있다.)
	 * */
	@Autowired
	public MakeRandomString(RandomGenerator random) {
		this.random = random;
	}
	
	public String getRandomLengthString() {
		
		StringBuilder sb = new StringBuilder();
		
		int randomNumber = random.getRandomNumber();
		for(int i = random.getStartNum(); i <= randomNumber; i++) {
			sb.append("*");
		}
		
		return sb.toString();
	}
}
