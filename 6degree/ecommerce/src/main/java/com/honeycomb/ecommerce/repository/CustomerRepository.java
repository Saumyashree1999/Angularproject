package com.honeycomb.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.honeycomb.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Boolean existsByEmail(String email);

	boolean existsByPassword(String password);

//
	Boolean existsByMobileno(String mobileno);

	Optional<Customer> findById(Long id);

	Optional<Customer> findByEmail(String email);

	// void findByEmail(Optional<Customer> findByEmail);
//	@Query("SELECT distinct customer FROM Customer customer"
//			+ " JOIN CustomerAddress caddress ON (caddress.isdeleted=0 And caddress.customerId =customer.id)"
//			+ " JOIN Order ordr ON (ordr.isdeleted = 0 And ordr.customerAddressId =caddress.id)"
//			+ " JOIN OrderDetails odetail ON (odetail.isdeleted = 0 And odetail.orderId =ordr.id)"
//			+ " JOIN Variant vari ON (vari.isdeleted = 0 And odetail.variantId =vari.id)"
//			+ " JOIN Product prod ON (prod.isdeleted = 0 And vari.productId =prod.id)"
//			+ " JOIN Brand brnd ON (brnd.isdeleted = 0 And prod.brandId =brnd.id)"
//			+ " JOIN Designer design ON (design.isdeleted = 0 And brnd.designerId=design.id)"
//			+ " WHERE (design.id =:id And customer.isdeleted = 0)")

	@Query("SELECT customer from Customer customer"
			+ " JOIN Designer designer ON ( designer.isdeleted=0 And customer.designerId=designer.id)"
			+ " WHERE designer.id =:id And customer.isdeleted = 0")
	List<Customer> getCustomerDetailsByDesignerId(@Param("id") Long id);

//	@Query("SELECT customer FROM Customer customer WHERE customer.id IN"
//			+ " (SELECT caddress FROM CustomerAddress caddress"
//			+ " JOIN Order ordr ON (ordr.isdeleted = 0 And ordr.customerAddressId =caddress.id)"
//			+ " JOIN OrderDetails odetail ON (odetail.isdeleted = 0 And odetail.orderId =ordr.id)"
//			+ " JOIN Variant vari ON (vari.isdeleted = 0 And odetail.variantId =vari.id)"
//			+ " JOIN Product prod ON (prod.isdeleted = 0 And vari.productId =prod.id)"
//			+ " JOIN Brand brnd ON (brnd.isdeleted = 0 And prod.brandId =brnd.id)"
//			+ " JOIN Designer design ON (design.isdeleted = 0 And brnd.designerId=design.id)"
//			+ " WHERE (design.id =:id And customer.isdeleted = 0))")
//	List<Customer> getCustomerDetailsForDesigner(@Param("id") Long id);

}
