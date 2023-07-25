package com.honeycomb.ecommerce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.honeycomb.ecommerce.dto.CustomerRequest;
import com.honeycomb.ecommerce.dto.DesignerRequest;
import com.honeycomb.ecommerce.entity.Customer;
import com.honeycomb.ecommerce.entity.Designer;
import com.honeycomb.ecommerce.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer signUp(CustomerRequest customerRequest) {

		Customer customer = new Customer();
		customer.setFullName(customerRequest.getFullname());
		customer.setEmail(customerRequest.getEmail());
		customer.setPassword(customerRequest.getPassword());
		customer.setMobileno(customerRequest.getMobileno());

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodePassword = bCryptPasswordEncoder.encode(customerRequest.getPassword());

		customer.setPassword(encodePassword);
		return customerRepository.save(customer);
	}
//---------------------------------------------------------

//	public String signIn(CustomerRequest customerRequest) {
//
////		Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(charSeq, saltLength, iteration,
////				hashWidth);
//
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		Optional<Customer> optional = customerRepository.findByEmail(customerRequest.getEmail());
//		if (optional.isPresent()) {
//			Customer customer = optional.get();
//			if (bCryptPasswordEncoder.matches(customerRequest.getPassword(), customer.getPassword()))
//				return "authenticate Customer";
//			else
//				return "incorrect password";
//		}
//		return "Email doesn't exist";
//	}
//-----------------------------------------------------------------
	public ResponseEntity<Object> signIn(CustomerRequest customerRequest) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Optional<Customer> optional = customerRepository.findByEmail(customerRequest.getEmail());

		MultiValueMap<String, String> status = new HttpHeaders();
		status.add("status", "200");

		if (optional.isPresent()) {
			Customer customer = optional.get();
			if (bCryptPasswordEncoder.matches(customerRequest.getPassword(), customer.getPassword()))
				return new ResponseEntity<>(customer, status, HttpStatus.OK);
			else {
				Map<String, String> error = new HashMap<>();
				status.add("Password", "Invalid password");
				return new ResponseEntity<>(error, status, HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("email doesnot exist", HttpStatus.BAD_REQUEST);
	}

//------------------------------------------------------------------
	public Customer getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
	}
//--------------------------------------------

	public Customer getById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.get();
		// Designer designer = designerRepository.findById(id).get();
		// designer.se
	}

//-----------------------------------------------
	public List<Customer> getCustomersByDesignerId(Long id) {
		return customerRepository.getCustomerDetailsByDesignerId(id);
//		return null;
	}

//	public List<Customer> getCustomerForDesigner(Long id) {
//		return customerRepository.getCustomerDetailsForDesigner(id);
//	}

}
