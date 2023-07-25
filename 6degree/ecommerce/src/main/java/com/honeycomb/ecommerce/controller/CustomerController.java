package com.honeycomb.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honeycomb.ecommerce.dto.CustomerRequest;
import com.honeycomb.ecommerce.dto.DesignerRequest;
import com.honeycomb.ecommerce.entity.Customer;
import com.honeycomb.ecommerce.repository.CustomerRepository;
import com.honeycomb.ecommerce.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@Valid @RequestBody CustomerRequest customerRequest) {

		if (customerRequest.getFullname() == null) {

			return new ResponseEntity<>("name can't be null", HttpStatus.BAD_REQUEST);
		}
		if (customerRequest.getEmail() == null)
			return new ResponseEntity<>("email can't be null", HttpStatus.BAD_REQUEST);

		if (customerRepository.existsByEmail(customerRequest.getEmail()))
			return new ResponseEntity<>("Email is already exist", HttpStatus.BAD_REQUEST);

		if (customerRequest.getPassword().length() < 6 && customerRequest.getPassword().length() > 10)
			return new ResponseEntity<>("password must be between 6 to 10 ", HttpStatus.BAD_REQUEST);

		if (customerRepository.existsByMobileno(customerRequest.getMobileno()))
			return new ResponseEntity<>("mobile number already exists", HttpStatus.BAD_REQUEST);

		if (customerRequest.getMobileno() == null)
			return new ResponseEntity<>("enter valid number", HttpStatus.BAD_REQUEST);

		Customer customer = customerService.signUp(customerRequest);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

//--------------------------------------------------
//	@PostMapping("/login")
//	public String signIn(@RequestBody CustomerRequest customerRequest) {
//		return customerService.signIn(customerRequest);
//
//	}

	@PostMapping("/login")
	public ResponseEntity<Object> signIn(@RequestBody CustomerRequest customerRequest) {
		return customerService.signIn(customerRequest);
	}

//-----------------------------------
	@PostMapping("/getbyid/{id}")
	public Customer getCustomerById(@PathVariable(name = "id") Long id) {
		return customerService.getById(id);
	}

//------------------------
	@PostMapping("/designer/{id}")
	public List<Customer> getCustomerByDesignerId(@PathVariable Long id) {
		return customerService.getCustomersByDesignerId(id);
	}

//	@GetMapping("/getBydesigner/{id}")
//	public List<Customer> getCustomerForDesigner(@PathVariable Long id) {
//		return customerService.getCustomerForDesigner(id);
//	}

}
