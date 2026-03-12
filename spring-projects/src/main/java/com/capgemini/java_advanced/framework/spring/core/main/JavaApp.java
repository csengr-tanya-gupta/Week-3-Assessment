package com.capgemini.java_advanced.framework.spring.core.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.java_advanced.framework.spring.core.Product;

public class JavaApp {
	
	public static void execution() {
		String xmlConfigurationFile = "applicationContext.xml";
		ConfigurableApplicationContext configurableApplicationContext = new ClassPathXmlApplicationContext(xmlConfigurationFile);
		Product product = configurableApplicationContext.getBean("product1", Product.class);
		System.out.println(product);
		configurableApplicationContext.close();
	}

}
