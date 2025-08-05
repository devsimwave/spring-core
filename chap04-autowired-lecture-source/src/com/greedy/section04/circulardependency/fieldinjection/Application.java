package com.greedy.section04.circulardependency.fieldinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.greedy.section04.circulardependency.fieldinjection")
public class Application {
    public static void main(String[] args) {

        // 필드 주입은 순환참조가 생겨도 오류가 안나는걸 확인할 수 있다.
        System.out.println("ApplcationContext 초기화 시작");
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        System.out.println("OrderService 빈 호출 시도");
        OrderService orderService = context.getBean(OrderService.class);
        orderService.completeOrder();

    }
}
