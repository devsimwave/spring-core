package com.greedy.section01.fieldinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.greedy.section01.fieldinjection.javaconfig");
		
		BookService bookService = context.getBean("bookService", BookService.class);
		
		for(BookDTO b : bookService.selectAllBooks()) {
			System.out.println(b);
		}
		
		System.out.println(bookService.searchBookBySequence(2));

	}

}
