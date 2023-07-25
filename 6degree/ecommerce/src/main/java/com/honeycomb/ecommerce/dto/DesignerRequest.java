package com.honeycomb.ecommerce.dto;

public class DesignerRequest {

//	 @NotBlank(message = "name should not be null")
	private String name;

	// @Email
//	 @NotNull(message = "email can't be null")
	private String email;

//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{6,9}$",
  //message = "Invalid password")
	private String password;
	
//	private String confirmPassword;

	//@Pattern(regexp = "^(7|8|9)\\d{9}$", message = "Invalid mobile number")
	private String mobilenumber;

	private String addressline1;

	private String addressline2;

	private String landmark;

	private String city;

	// @NotNull(message = "state can't be empty")
	private String state;

	// @NotNull(message = "country can't be empty")
	private String country;

	// @NotNull(message = "pincode can't be empty")
	private String pincode;

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

	public String getPassword() {
		return password;
	}

//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "DesignerRequest [name=" + name + ", email=" + email + ", password=" + password + ", mobilenumber="
				+ mobilenumber + ", addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", landmark="
				+ landmark + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode
				+ "]";
	}
	

}
