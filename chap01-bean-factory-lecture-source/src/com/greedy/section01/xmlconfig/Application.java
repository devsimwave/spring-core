package com.greedy.section01.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("com/greedy/section01/xmlconfig/spring-context.xml");
		
		/* context를 생성할 시 설정 정보에 등록된 bean을 컨테이너의 라이프사이클을 유지하는동안 유지하고 있다.
		 * 이 때 컨테이너가 보관하고 있는 bean을 꺼내서 사용할 때 getBean() 메소드를 이용할 수 있다.
		 * */
		
		/* 1. bean의 id를 이용해 bean을 가져오는 방법 */
//		MemberDTO member = (MemberDTO) context.getBean("member");
		
		/* 2. bean의 타입정보를 전달하여 가져오는 방법 */
//		MemberDTO member = context.getBean(MemberDTO.class);
		
		/* 3. bean의 id와 클래스 메타정보를 전달하여 가져오는 방법 */
		MemberDTO member = context.getBean("member", MemberDTO.class);
		
		System.out.println(member);
	}

}
