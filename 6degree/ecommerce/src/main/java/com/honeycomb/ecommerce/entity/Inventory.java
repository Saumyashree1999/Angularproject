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
@Table(name = "inventory")
public class Inventory extends CreateUpdateDelete {

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "store_id")
	private long storeId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "store_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Store store;

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

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

}
