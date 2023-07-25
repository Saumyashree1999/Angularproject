package com.saumya.demo.dto;

//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;

public class Base {

//	@NotBlank(message = "name should not be null")
	private String name;

//	@Email
//	@NotNull(message = "email can't be null")
	private String email;

//	@Pattern(regexp = "^(7|8|9)\\d{9}$", message = "Invalid mobile number")
	private String mobilenumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

}
