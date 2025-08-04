package com.greedy.section02.locale.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ContextConfiguration {
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		
		/* 접속하는 세션의 로케일에 따라 자동 재로딩 하는 용도의 MessageSource 구현체 */
		ReloadableResourceBundleMessageSource messageSource =
				new ReloadableResourceBundleMessageSource();
		
		/* 다국어 메세지를 읽어올 properties 파일의 기본 파일 이름 설정 */
		messageSource.setBasename("message");
		/* 불러온 메세지를 해당 시간 동안 캐싱한다. */
		messageSource.setCacheSeconds(10);
		/* 기본 인코딩셋 설정 */
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
}
