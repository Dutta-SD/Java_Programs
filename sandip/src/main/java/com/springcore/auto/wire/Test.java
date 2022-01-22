package com.springcore.auto.wire;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config_autowire.xml");
		Emp e1 = context.getBean("e1", Emp.class);
		System.out.println(e1);
		context.close();
	}

}
