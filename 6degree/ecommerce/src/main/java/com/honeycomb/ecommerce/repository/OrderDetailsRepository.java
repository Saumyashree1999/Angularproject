package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
