package com.greedy.section02.locale.xmlconfig;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context =
				new GenericXmlApplicationContext("com/greedy/section02/locale/xmlconfig/config/spring-context.xml");
		
		String error404Message = context.getMessage("error.404", null, Locale.US);
		String error500Message = context.getMessage("error.500", new Object[] {"jinho", new java.util.Date()}, Locale.US);
		
		
		System.out.println("The I18N message for error.404 : " + error404Message);
		System.out.println("The I18N message for error.500 : " + error500Message);

	}
	
	
	

}
