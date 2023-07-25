package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {

}
