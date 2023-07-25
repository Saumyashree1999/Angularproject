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
@Table(name = "product")
public class Product extends CreateUpdateDelete {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "productnumber", unique = true)
	private String productNumber;

	@Column(name = "subtype_id")
	private long subtypeId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "subtype_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Subtype subtype;

	@Column(name = "material_id")
	private long materialId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "material_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Material material;

	@Column(name = "washcare_id")
	private long washcareId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "washcare_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Washcare washcare;

	@Column(name = "category_id")
	private long categoryId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Category category;

	@Column(name = "brand_id")
	private long brandId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "brand_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Brand brand;

	@JsonIgnore
	@OneToMany(mappedBy = "productId")
	private List<Variant> variants;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public Long getSubtypeId() {
		return subtypeId;
	}

	public void setSubtypeId(Long subtypeId) {
		this.subtypeId = subtypeId;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Long getWashcareId() {
		return washcareId;
	}

	public void setWashcareId(Long washcareId) {
		this.washcareId = washcareId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Subtype getSubtype() {
		return subtype;
	}

	public void setSubtype(Subtype subtype) {
		this.subtype = subtype;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Washcare getWashcare() {
		return washcare;
	}

	public void setWashcare(Washcare washcare) {
		this.washcare = washcare;
	}

	public List<Variant> getVariants() {
		return variants;
	}

	public void setVariants(List<Variant> variants) {
		this.variants = variants;
	}

}
