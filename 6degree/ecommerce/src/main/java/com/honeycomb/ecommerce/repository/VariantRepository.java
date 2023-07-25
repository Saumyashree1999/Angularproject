package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Variant;

public interface VariantRepository extends JpaRepository<Variant, Long> {

}
