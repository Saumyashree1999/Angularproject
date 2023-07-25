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
@Table(name = "image")
public class Image extends CreateUpdateDelete {

	@Column(name = "path")
	private String path;

	@Column(name = "heirarchy")
	private int heirarchy;

	@Column(name = "variants_id")
	private long variantId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "variants_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Variant variant;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getHeirarchy() {
		return heirarchy;
	}

	public void setHeirarchy(int heirarchy) {
		this.heirarchy = heirarchy;
	}

	public Long getVariantId() {
		return variantId;
	}

	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

}
