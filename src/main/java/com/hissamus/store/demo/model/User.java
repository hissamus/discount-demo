package com.hissamus.store.demo.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
	
	@Column(name = "NAME")
    private String name;
	
	@Column(name = "IS_AFFLIATED_INDICATOR")
    private boolean isAffliated;
	
	@Column(name = "IS_EMPLOYEE_INDICATOR")
    private boolean isEmployee;
	
	@Column(name = "DATE")
    private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAffliated() {
		return isAffliated;
	}

	public void setAffliated(boolean isAffliated) {
		this.isAffliated = isAffliated;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
