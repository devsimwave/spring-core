package com.greedy.section02.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Application {

	public static void main(String[] args) {
		
		/* 리플렉션이란?
		 * 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법으로 반사, 투영이라는 의미를 가진다.
		 * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
		 * 스프링프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용한다.
		 * 
		 * 특히 스프링 프레임워크는 런타임시에 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있게 만들었다.
		 * 
		 * reflection은 매우 강력한 도구이지만 무분별하게 사용해서는 안된다.
		 * 주의사항
		 * 1. 오버헤드 발생 : 성능 저하를 발생시킬 수 있기 때문에 성능에 민감한 애플리케이션에서는 사용하지 않는다.
		 * 2. 캡슐화 저해 : private로 설정한 member에 접근이 가능하기에 코드 기능이 저하되며 여러 가지 문제 발생 가능성을 높인다.
		 * 
		 * 리플렉션이 사용되는 경우
		 * 1. IoC컨테이너
		 * 2. AOP
		 * 3. 마이바티스 매퍼
		 * 4. log4jdbc
		 * 등이 있다.
		 *  */
		
		/* .class 문법을 이용하여 Class 타입의 인스턴스를 생성할 수 있다.
		 * Class 타입의 인스턴스는 해당 클래스의 메타정보를 가지고 있는 클래스이다.
		 * */
		Class class1 = Account.class;
		System.out.println("class1 : " + class1);
		
		/* Object 클래스의 getClass() 메소드를 이용하면 Class타입으로 리턴받아 이용할 수 있다. */
		Class class2 = new Account().getClass();
		System.out.println("class2 : " + class2);
		
		try {
			Class class3 = Class.forName("com.greedy.section02.reflection.Account");
			System.out.println("class3 : " + class3);
			
			Class class4 = Class.forName("[D");
			Class class5 = double[].class;
			
			System.out.println("class4 : " + class4);
			System.out.println("class5 : " + class5);
			
			Class class6 = Class.forName("[Ljava.lang.String;");
			Class class7 = String[].class;
			
			System.out.println("class6 : " + class6);
			System.out.println(new String[] {"apple", "banana"});
			System.out.println("class7 : " + class7);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/* 원시 자료형을 사용하면 컴파일 에러 발생 */
//		double d = 1.0;
//		Class class8 = d.getClass();
		
		Class class8 = Double.TYPE;
		System.out.println("class8 : " + class8);
		
		Class class9 = Void.TYPE;
		System.out.println("class9 : " + class9);
		
		/* 클래스의 메타 정보를 이용하여 여러 가지 정보를 반환받는 메소드를 제공한다. */
		/* 상속된 부모 클래스를 반환한다. */
		Class superClass = class1.getSuperclass();
		System.out.println("superClass : " + superClass);
		
		/* 필드 정보를 반환한다. */
		Field[] fields = Account.class.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("modifiers : " + Modifier.toString(field.getModifiers())
						+ ", type : " + field.getType()
						+ ", name : " + field.getName());
		}
		
		/* 생성자 정보를 반환받는다. */
		Constructor[] constructors = Account.class.getConstructors();
		for(Constructor con : constructors) {
			System.out.println("name : " + con.getName());
			
			Class[] params = con.getParameterTypes();
			for(Class param : params) {
				System.out.println("paramType : " + param.getTypeName());
			}
		}
		
		/* 생성자를 이용하여 인스턴스를 생성할 수 있다. */
		try {
			Account acc = (Account) constructors[0].newInstance("20", "110-223-123456", "1234", 10000);
			
			System.out.println(acc.getBalance());
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		
		/* 메소드의 정보도 반환받을 수 있다. */
		Method[] methods = Account.class.getMethods();
		
		Method getBalanceMethod = null;
		for(Method method : methods) {
			System.out.println(Modifier.toString(method.getModifiers()) + " "
					+ method.getReturnType().getSimpleName() + " "
					+ method.getName());
			
			if("getBalance".equals(method.getName())) {
				getBalanceMethod = method;
			}
		}
		
		/* invoke 메소드로 메소드를 호출할 수 있다. */
		try {
			System.out.println(getBalanceMethod.invoke(((Account) constructors[2].newInstance()), null));
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			e.printStackTrace();
		}
		
	}

}

















