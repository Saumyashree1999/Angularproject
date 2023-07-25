package com.honeycomb.ecommerce.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cart")
public class Cart extends CreateUpdateDelete {

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "customer_id")
	private long customerId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Customer customer;

	@Column(name = "variants_id")
	private long variantId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "variants_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Variant variant;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

}
