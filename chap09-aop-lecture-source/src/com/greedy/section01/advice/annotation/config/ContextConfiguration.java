package com.greedy.section01.advice.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) // aspectj를 이용해 스프링 프록시를 활성화를 시키는 어노테이션이다. 스프링은 프록시 객체를 사용해 aop를 사용할 수 있기 때문에 설정해줘야 한다.
public class ContextConfiguration {

}
