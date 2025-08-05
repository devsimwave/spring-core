package com.greedy.section04.circulardependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.greedy.section04.circulardependency")
public class Application {
    public static void main(String[] args) {

        /* 순환참조 문제란 A 클래스가 B 클래스에 의존하고, B 클래스가 A 클래스에 의존하는 상황을 말한다.
        * 이 떄 스프링이 두 객체를 모두 생성하려다 서로로 필요로 하니 무한 루프에 빠져 에러가 난다. */
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.completeOrder();


    }
}
