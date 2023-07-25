package com.honeycomb.ecommerce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "paymentdetails")
public class PaymentDetails extends CreateUpdateDelete {

	@Column(name = "mode")
	private String mode;

	@JsonIgnore
	@OneToMany(mappedBy = "paymentDetailsId")
	private List<Order> orders;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
