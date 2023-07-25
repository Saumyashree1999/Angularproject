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
@Table(name = "brand")
public class Brand extends CreateUpdateDelete {

	@Column(name = "name")
	private String name;

	@Column(name = "logo")
	private String logo;

	@Column(name = "description")
	private String description;

	@Column(name = "designer_id")
	private long designerId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "designer_id",foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT), insertable = false, updatable = false)
	private Designer designer;

	@JsonIgnore
	@OneToMany(mappedBy = "brandId")
	private List<Storebrand> storebrands;

	@JsonIgnore
	@OneToMany(mappedBy = "brandId")
	private List<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

	public List<Storebrand> getStorebrands() {
		return storebrands;
	}

	public void setStorebrands(List<Storebrand> storebrands) {
		this.storebrands = storebrands;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public long getDesignerId() {
		return designerId;
	}

	public void setDesignerId(long designerId) {
		this.designerId = designerId;
	}

}
