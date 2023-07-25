package com.honeycomb.ecommerce.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CustomerRequest {

	@NotNull(message = "name should not be null")
	private String fullname;

	@Email
	@NotNull(message = "email can't be null")
	private String email;

	
	
	/*
	 * Explanation of the regex pattern:
	 * 
	 * ^ asserts the start of the string. (?=.*[a-z]) is a positive lookahead that
	 * ensures the password contains at least one lowercase letter. (?=.*[A-Z]) is a
	 * positive lookahead that ensures the password contains at least one uppercase
	 * letter. (?=.*\\d) is a positive lookahead that ensures the password contains
	 * at least one digit. (?=.*[@#$%^&+=]) is a positive lookahead that ensures the
	 * password contains at least one special character. Modify the character set
	 * [@#$%^&+=] as needed to include other special characters. (?=\\S+$) is a
	 * positive lookahead that ensures the password does not contain any whitespace.
	 * .{6,9} matches the password that has a length between 6 and 9 characters. $
	 * asserts the end of the string.
	 */

//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{6,9}$", message = "Invalid password")
	private String password;

//	@Pattern(regexp = "^(7|8|9)\\d{9}$", message = "Invalid mobile number")
	private String mobileno;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	@Override
	public String toString() {
		return "CustomerRequest [fullname=" + fullname + ", email=" + email + ", password=" + password + ", mobileno="
				+ mobileno + "]";
	}

}
