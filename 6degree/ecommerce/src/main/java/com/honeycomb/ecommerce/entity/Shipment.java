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
@Table(name = "shipment")
public class Shipment extends CreateUpdateDelete {

	@Column(name = "orderdetails_id")
	private long orderDetailsId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "orderdetails_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private OrderDetails orderDetails;

	@Column(name = "status_id")
	private long statusId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "status_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Status status;

	@Column(name = "logisticpartner")
	private String logisticPartner;

	public Long getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(Long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getLogisticPartner() {
		return logisticPartner;
	}

	public void setLogisticPartner(String logisticPartner) {
		this.logisticPartner = logisticPartner;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
