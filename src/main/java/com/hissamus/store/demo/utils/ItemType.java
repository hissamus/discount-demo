package com.hissamus.store.demo.utils;

public enum ItemType {

	GROCERY("GROCERY"),
	OTHER("OTHER");
	
	private String type;
	ItemType(String type){
		this.type=type;
	}
	
	public String getValue() {
		return type;
	}
}
