package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
