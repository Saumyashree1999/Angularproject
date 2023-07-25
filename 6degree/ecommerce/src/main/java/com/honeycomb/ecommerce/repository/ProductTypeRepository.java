package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
