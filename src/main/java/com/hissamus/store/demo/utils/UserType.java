package com.hissamus.store.demo.utils;

public enum UserType {

	AFFILIATE(10),
	EMPLOYEE(30),
	OLD_CUSTOMER(2);

	private double percentage;

	UserType(double percentage) {
		this.percentage = percentage;
	}

	public double getValue() {
		return percentage;
	}
}
