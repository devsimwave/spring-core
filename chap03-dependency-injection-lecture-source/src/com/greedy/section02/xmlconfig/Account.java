package com.greedy.section02.xmlconfig;

public interface Account {
	
	/* 잔액조회 */
	String getBalance();
	
	/* 입금 */
	String deposit(int money);
	
	/* 출금 */
	String withDraw(int money);
}
