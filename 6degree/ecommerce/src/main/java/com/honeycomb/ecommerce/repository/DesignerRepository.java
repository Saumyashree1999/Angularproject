package com.honeycomb.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.honeycomb.ecommerce.entity.Designer;

public interface DesignerRepository extends JpaRepository<Designer, Long> {

	Boolean existsByEmail(String email);

	boolean existsByPassword(String password);

	Boolean existsByMobilenumber(String mobilenumber);

	Optional<Designer> findById(Long id);
	Optional<Designer> findByEmail(String string);

//	Designer findByEmail1(String email);
	
	void findByEmail(Optional<Designer> findByEmail);

	//@Query("select designer from Designer designer where designer.email= :email and designer.isDeleted=0 ")
	
	
//	Optional<Designer> findByEmail1(@Param("email") String email);
	@Query("UPDATE Designer SET isdeleted=1 WHERE id =:id")
	void deleteId(@Param("id") Long id);

}
