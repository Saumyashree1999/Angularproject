package com.honeycomb.ecommerce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "producttype")
public class ProductType extends CreateUpdateDelete {

	@Column(name = "name")
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "productTypeId")
	private List<Subtype> subtypes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subtype> getSubtypes() {
		return subtypes;
	}

	public void setSubtypes(List<Subtype> subtypes) {
		this.subtypes = subtypes;
	}

}
