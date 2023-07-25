package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
