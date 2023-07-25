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
@Table(name = "customer")
public class Customer extends CreateUpdateDelete {

	@Column(name = "fullname")
	private String fullname;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "mobileno", unique = true)
	private String mobileno;

	@JsonIgnore
	@OneToMany(mappedBy = "customerId")
	private List<CustomerAddress> customerAddresses;

	@JsonIgnore
	@OneToMany(mappedBy = "customerId")
	private List<RatingReview> ratingReviews;

	@JsonIgnore
	@OneToMany(mappedBy = "customerId")
	private List<Cart> carts;

	@Column(name = "designer_id")
	private long designerId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "designer_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	private Designer designer;

	public String getFullName() {
		return fullname;
	}

	public void setFullName(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileNumber) {
		this.mobileno = mobileNumber;
	}

	public List<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public List<RatingReview> getRatingReviews() {
		return ratingReviews;
	}

	public void setRatingReviews(List<RatingReview> ratingReviews) {
		this.ratingReviews = ratingReviews;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public long getDesignerId() {
		return designerId;
	}

	public void setDesignerId(long designerId) {
		this.designerId = designerId;
	}

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

}
