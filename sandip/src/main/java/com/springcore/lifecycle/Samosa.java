package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Samosa {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}

	public Samosa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		System.out.println("Inside Samosa Init method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Inside Samosa Destroy Method");
	}

}
