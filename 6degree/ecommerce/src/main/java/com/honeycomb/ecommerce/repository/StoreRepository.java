package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
