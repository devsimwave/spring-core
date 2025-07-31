package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.javaconfig.Account;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration1 {
	
	@Bean
	public Account accountGenerator() {
		
		return new PersonalAccount(20, "110-234-567890", "1234");
	}
	
	@Bean
	public MemberDTO memberGenerator() {
		
		return new MemberDTO(1, "홍길동", "010-1234-5678", "hong123@gmail.com", accountGenerator());
	}
}








