package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.honeycomb.ecommerce.entity.Image;


public interface ImageRepository extends JpaRepository<Image, Long> {

}
