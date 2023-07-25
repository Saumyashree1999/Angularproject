package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {

}
