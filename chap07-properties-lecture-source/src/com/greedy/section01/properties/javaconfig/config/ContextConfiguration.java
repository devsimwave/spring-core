package com.greedy.section01.properties.javaconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.properties.javaconfig.Beverage;
import com.greedy.section01.properties.javaconfig.Bread;
import com.greedy.section01.properties.javaconfig.Product;
import com.greedy.section01.properties.javaconfig.ShoppingCart;

@Configuration
@PropertySource("product-info.properties")
public class ContextConfiguration {
	
	@Value("${bread.carpbread.name:붕어빵}")
	private String carpBreadName;
	
	@Value("${bread.carpbread.price:0}")
	private int carpBreadPrice;
	
	@Value("${beverage.milk.name:}")
	private String milkName;
	
	@Value("${beverage.milk.price:0}")
	private int milkPrice;
	
	@Value("${beverage.milk.capacity:0}")
	private int milkCapacity;
	
	@Bean
	public Product carpBread() {
		
		return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
	}
	
	@Bean 
	public Product milk() {
		
		return new Beverage(milkName, milkPrice, milkCapacity);
	}
	
	@Bean
	public Product water(@Value("${beverage.water.name:}") String waterName, 
			@Value("${beverage.water.price:0}") int waterPrice, 
			@Value("${beverage.water.capacity:0}") int waterCapacity) {
		
		return new Beverage(waterName, waterPrice, waterCapacity);
	}
	
	@Bean
	@Scope("prototype")
	public ShoppingCart cart() {
		
		return new ShoppingCart();
	}
}
