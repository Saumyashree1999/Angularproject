package com.honeycomb.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.honeycomb.ecommerce.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
