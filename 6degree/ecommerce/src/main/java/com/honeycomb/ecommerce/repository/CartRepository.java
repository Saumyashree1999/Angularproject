package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
