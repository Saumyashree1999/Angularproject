package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Storebrand;

public interface StoreBrandRepository extends JpaRepository<Storebrand, Long> {

}
