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
@Table(name = "variants")
public class Variant extends CreateUpdateDelete {

	@Column(name = "mrp")
	private double mrp;

	@Column(name = "sellingprice")
	private double sellingPrice;

	@Column(name = "product_id")
	private long productId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Product product;

	@Column(name = "size_id")
	private long sizeId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "size_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Size size;

	@Column(name = "color_id")
	private long colorId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "color_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private Color color;

	@Column(name = "weighttype_id")
	private long weightTypeId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "weighttype_id",foreignKey = @ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT),nullable = false,updatable = false,insertable = false)
	private WeightType weightType;

	@Column(name = "weight")
	private double weight;

	@Column(name = "quantity")
	private int quantity;

	@JsonIgnore
	@OneToMany(mappedBy = "variantId")
	private List<Inventory> inventories;

	@JsonIgnore
	@OneToMany(mappedBy = "variantId")
	private List<Image> images;

	@JsonIgnore
	@OneToMany(mappedBy = "variantId")
	private List<OrderDetails> orderDetails;

	@JsonIgnore
	@OneToMany(mappedBy = "variantId")
	private List<Cart> carts;

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getSizeId() {
		return sizeId;
	}

	public void setSizeId(long sizeId) {
		this.sizeId = sizeId;
	}

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public long getWeightTypeId() {
		return weightTypeId;
	}

	public void setWeightTypeId(long weightTypeId) {
		this.weightTypeId = weightTypeId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Inventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<Inventory> inventories) {
		this.inventories = inventories;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public WeightType getWeightType() {
		return weightType;
	}

	public void setWeightType(WeightType weightType) {
		this.weightType = weightType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

}
