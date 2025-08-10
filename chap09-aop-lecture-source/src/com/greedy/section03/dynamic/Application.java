package com.greedy.section03.dynamic;

import java.lang.reflect.Proxy;

public class Application {

	public static void main(String[] args) {
		
		/* 프록시란?
		 * 실제 Target의 기능을 수행하면서 기능을 확장하거나 추가하는 실제 객체를 의미한다.
		 * 디자인 패턴의 프록시 패턴과는 비슷하면서 조금 다른 기능이긴 하다.
		 * */
		Student student = new GreedyStudent();
		Handler handler = new Handler(student);
		
		/* 프록시 생성 */
		Student proxy = 
				(Student) Proxy.newProxyInstance(Student.class.getClassLoader(), 
						new Class[] {Student.class}, handler);
		
		proxy.study(16);
		
	}

}
