package com.example.databasefun;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customerorder")
public class CustomerOrder {

	@Id
	@GeneratedValue
	private Long order_id;

	@OneToMany
	@JoinColumn(name = "customer_id")
	private Long customer_id;

	private double amount;

	public Long getOrder_id() {
		return order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
