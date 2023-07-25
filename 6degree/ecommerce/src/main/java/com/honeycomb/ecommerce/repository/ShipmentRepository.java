package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}
