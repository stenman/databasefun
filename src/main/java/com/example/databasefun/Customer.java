package com.example.databasefun;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private Long customer_id;

	@Column(length = 50)
	private String customer_firstname;

	@Column(length = 50)
	private String customer_lastname;

	public long getId() {
		return customer_id;
	}

	public String getFirstName() {
		return customer_firstname;
	}

	public void setFirstName(String firstName) {
		this.customer_firstname = firstName;
	}

	public String getLastName() {
		return customer_lastname;
	}

	public void setLastName(String lastName) {
		this.customer_lastname = lastName;
	}
}
