package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

}
