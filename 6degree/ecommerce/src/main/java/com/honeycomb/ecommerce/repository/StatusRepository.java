package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
