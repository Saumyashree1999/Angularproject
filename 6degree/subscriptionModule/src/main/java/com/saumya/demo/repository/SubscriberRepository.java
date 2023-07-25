package com.saumya.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saumya.demo.entity.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {

	Boolean existsByMobilenumber(String mobilenumber);

	Boolean existsByEmail(String email);

}
