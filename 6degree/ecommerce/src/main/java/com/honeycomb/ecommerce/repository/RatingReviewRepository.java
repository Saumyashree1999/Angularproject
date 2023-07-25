package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.RatingReview;

public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {

}
