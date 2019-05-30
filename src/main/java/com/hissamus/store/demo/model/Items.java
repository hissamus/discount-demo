package com.hissamus.store.demo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Items {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
    private Long id;
	
	@Column(name = "TYPE")
    private String type;
	
	@Column(name = "PRODUCT")
    private String product;
	
	@Column(name = "COST")
    private BigDecimal cost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("\n{\ngetId:"+id)
				.append("\n getType:"+type)
				.append("\n getProduct"+product)
				.append("\n getCost"+cost+"\n}").toString();				
	}
	
}

