package com.greedy.section04.circulardependency.constinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.greedy.section04.circulardependency.constinjection")
public class Application {
    public static void main(String[] args) {

        /*
        * 순환참조란 A 클래스가 B 클래스에 의존하고 B 클래스가 A 클래스에 의존하는 상황을 말한다.
        * 이 때 스프링이 두 객체를 모두 생성하려다 서로로 필요로 하니 순환이 발생하고 적절한 처리 없이 그대로 두면 예외가 발생한다.
        * 필드 주입과 세터 주입의 경우 객체 생성 이후에 의존성이 주입되므로 순환 참조가 런타임 시점에 감지된다.
        * 반면, 생성자 주입은 객체 생성 시점에 모든 의존성이 필요하기 때문에 ApplicationContext 초기화 과정에서 순환 참조가 즉시 감지되어 예외가 발생한다.
        * 그래서 스프링에서는 사전에 미리 오류를 대응할 수 있기 떄문에 생성자 주입 방식을 권장한다.
        * */
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.completeOrder();


    }
}
