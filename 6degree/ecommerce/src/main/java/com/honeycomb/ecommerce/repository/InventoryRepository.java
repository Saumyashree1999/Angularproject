package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
