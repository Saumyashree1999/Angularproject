package com.honeycomb.ecommerce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orderdetails")
public class OrderDetails extends CreateUpdateDelete {

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "expecteddeliverydate")
	private Date expectedDeliveryDate;

	@Column(name = "orders_id")
	private long orderId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "orders_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Order order;

	@Column(name = "variants_id")
	private long variantId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "variants_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Variant variant;

	@Column(name = "totalprice")
	private double totalPrice;

	@Column(name = "store_id")
	private long storeId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "store_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Store store;

	@JsonIgnore
	@OneToMany(mappedBy = "orderDetailsId")
	private List<Shipment> shipments;

	@JsonIgnore
	@OneToMany(mappedBy = "orderDetailId")
	private List<RatingReview> ratingReviews;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<RatingReview> getRatingReviews() {
		return ratingReviews;
	}

	public void setRatingReviews(List<RatingReview> ratingReviews) {
		this.ratingReviews = ratingReviews;
	}

}
