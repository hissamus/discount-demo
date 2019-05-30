package com.hissamus.store.demo.model;

import java.util.List;

public class Bill {
	
	
	private String userName;
	private List<Items> items;
	private Double grossBill;
	private String description="";
	private double discount;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Double getGrossBill() {
		return grossBill;
	}
	public void setGrossBill(Double grossBill) {
		this.grossBill = grossBill;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("{\nUsername:"+userName)
				.append(",discount:"+discount)
				.append(",grossBill:"+grossBill)
				.append(",description:"+description)
				.append(",items:{size"+items.size()+",["+items.toArray().toString() +"]}\n}").toString();
	}

}
