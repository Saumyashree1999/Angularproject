package com.saumya.springrestapi.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // @Controller+@ResponseBody
public class Employee {
//every handler method is mapped to a URI as exp employee in localhost
	// localhost:8080/employee

	// getEmployees() is handler method

	// @ResponseBody // used to return http response

	// @RequestMapping(value = "/employees", method = RequestMethod.GET)
	@GetMapping("/employees") // instead of requestmapping we can use this
	public String getEmployees() {
		return "display the list of employees";
	}

	//localhost:8080/employees/1
	@GetMapping("/employees/{id}")
	public String getEmployee(@PathVariable("id") Long id) {
		return "fetching the employee details for id : " + id;

	}
	
	//localhost:8080/employees?id=5
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam("id") Long id) {
		return "deleting the employee details for the id : "+id;
		
	}
}
