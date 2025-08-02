package com.greedy.section03.collection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Pokemon {

	@Override
	public void attack() {
		System.out.println("피카츄가 공격합니다!! 백만볼트~ 찌지지지지직~~~~");
	}
	
}
