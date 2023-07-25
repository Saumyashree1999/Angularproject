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
@Table(name = "ratingsandreviews")
public class RatingReview extends CreateUpdateDelete {

	@Column(name = "rating")
	private double rating;

	@Column(name = "comment")
	private String comment;

	@Column(name = "orderdetails_id")
	private long orderDetailId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "orderdetails_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private OrderDetails orderDetails;

	@Column(name = "customer_id")
	private long customerId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Customer customer;

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

}
