package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
