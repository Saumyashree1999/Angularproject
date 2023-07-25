package com.honeycomb.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.honeycomb.ecommerce.dto.DesignerRequest;
import com.honeycomb.ecommerce.entity.Designer;
import com.honeycomb.ecommerce.repository.DesignerRepository;
import java.util.*;

@Service
public class DesignerService {

//	private String charSeq = "saumya";
//	private Integer saltLength = 16;
//	private Integer iteration = 400000;
//	private Integer hashWidth = 256;
	@Autowired
	private DesignerRepository designerRepository;

	@Autowired
	private JavaMailSender javaMailSender;

//	@Autowired
//    private PasswordEncoder passwordEncoder;

	private Map<String, String> otpMap = new HashMap<>();

	public Designer saveOrUpdateDesigner(DesignerRequest designerRequest) {
		Designer designer = new Designer();
		designer.setName(designerRequest.getName());
		designer.setEmail(designerRequest.getEmail());
		designer.setPassword(designerRequest.getPassword());
		designer.setMobilenumber(designerRequest.getMobilenumber());
		designer.setAddressline1(designerRequest.getAddressline1());
		designer.setAddressline2(designerRequest.getAddressline2());
		designer.setLandmark(designerRequest.getLandmark());
		designer.setCity(designerRequest.getCity());
		designer.setState(designerRequest.getState());
		designer.setCountry(designerRequest.getCountry());
		designer.setPincode(designerRequest.getPincode());
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodePassword = bCryptPasswordEncoder.encode(designerRequest.getPassword());

		// Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new
		// Pbkdf2PasswordEncoder(charSeq, saltLength, iteration,
//				hashWidth);
		// String encodePassword =
		// bCryptPasswordEncoder.encode(designerRequest.getPassword());

		designer.setPassword(encodePassword);
		return designerRepository.save(designer);

	}
//-------------------------------------------------------------------------------------------------------------
//	public String signIn(DesignerRequest designerRequest) {
//
////		Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder(charSeq, saltLength, iteration,
////				hashWidth);
//
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		Optional<Designer> optional = designerRepository.findByEmail(designerRequest.getEmail());
//		if (optional.isPresent()) {
//			Designer designer = optional.get();
//			if (bCryptPasswordEncoder.matches(designerRequest.getPassword(), designer.getPassword()))
//				return "authenticate user";
//			else
//				return "incorrect password";
//		}
//		return "email doesn't exist";

//----------------------------------------------------------------------
	public ResponseEntity<Object> signIn(DesignerRequest designerRequest) {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Optional<Designer> optional = designerRepository.findByEmail(designerRequest.getEmail());

		MultiValueMap<String, String> status = new HttpHeaders();
		status.add("status", "200");

		if (optional.isPresent()) {
			Designer designer = optional.get();
			if (bCryptPasswordEncoder.matches(designerRequest.getPassword(), designer.getPassword()))
				return new ResponseEntity<>(designer, status, HttpStatus.OK);
			else {
				Map<String, String> error = new HashMap<>();
				status.add("Password", "Invalid password");
				return new ResponseEntity<>(error, status, HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("email doesnot exist", HttpStatus.BAD_REQUEST);
//-------------------------------------------------------------

		/*
		 * BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		 * Optional<Designer> optional =
		 * designerRepository.findByEmail(designerRequest.getEmail()); if
		 * (optional.isPresent()) { Designer designer = optional.get(); if
		 * (bCryptPasswordEncoder.matches(designerRequest.getPassword(),
		 * designer.getPassword())) return "authenticate user"; else return
		 * "incorrect password"; } return "email doesn't exist";
		 */
	}

	public Iterable<Designer> listAll() {
		return this.designerRepository.findAll();
	}

	public Designer getDesignerById(Long id) {
		Optional<Designer> design = designerRepository.findById(id);
		return design.get();
		// Designer designer = designerRepository.findById(id).get();
		// designer.se
	}

	public String deleteDesigner(Long id) {
		Optional<Designer> optional = designerRepository.findById(id);
		if (optional.isPresent()) {
			Designer designer = optional.get();
			if (designer.getIsdeleted() == 0) {
				designer.setIsdeleted(1);
				designerRepository.save(designer);
				return "Designer deleted successfully";
			} else {
				return "Designer already deleted";
			}

		} else {
			// Handle user not found error
			return "Designer not present";
		}
	}

	public ResponseEntity<Object> update(Long id, DesignerRequest designerRequest) {

		Optional<Designer> optionalDesigner = designerRepository.findById(id);
		if (optionalDesigner.isPresent()) {
//			return saveOrUpdateDesigner(designerRequest);
			Designer designer = optionalDesigner.get();

			if (designer.getIsdeleted() == 0) {

				if (designerRequest.getName() != null) {
					HashMap<String, Object> name = new HashMap<>();
					name.put("name", "Enter valid name");
					if (designerRequest.getName().isBlank())
						return new ResponseEntity<Object>(name, HttpStatus.OK);
					else
						designer.setName(designerRequest.getName());
				}

				if (designerRequest.getEmail() != null) {
					if (designerRequest.getEmail().isBlank()) {
//					designer.setEmail(designer.getEmail());
						HashMap<String, Object> email = new HashMap<>();
						email.put("email", "Email can't be change");
						return new ResponseEntity<Object>(email, HttpStatus.OK);
					}
				}

				if (designerRequest.getPassword() != null) {
					String regex1 = "^(?=.*\\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{6,10}$";
					HashMap<String, Object> password = new HashMap<>();
					password.put("password", "Password must be 6 to 10 digit and contains atleast one digit, "
							+ "one special character, " + "one upper case & one lower case");
					if (!designerRequest.getPassword().matches(regex1)) {
//					designer.setEmail(designer.getEmail());

						return new ResponseEntity<Object>(password, HttpStatus.OK);
					} else {
						BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
						String encodePassword = bCryptPasswordEncoder.encode(designerRequest.getPassword());
						designer.setPassword(encodePassword);

					}
				}

				if (designerRequest.getMobilenumber() != null) {
					String regex = "^\\d{10}$";
					HashMap<String, Object> mobile = new HashMap<>();
					mobile.put("mobilenumber", "Enter valid mobilenumber");
					if (!designerRequest.getMobilenumber().matches(regex))
						return new ResponseEntity<Object>(mobile, HttpStatus.OK);
					else
						designer.setMobilenumber(designerRequest.getMobilenumber());

				}

				if (designerRequest.getAddressline1() != null) {
					HashMap<String, Object> address1 = new HashMap<>();
					address1.put("addressline1", "Enter valid addressline1");
					if (designerRequest.getAddressline1().isBlank())
						return new ResponseEntity<Object>(address1, HttpStatus.OK);
					else
						designer.setAddressline1(designerRequest.getAddressline1());

				}

				if (designerRequest.getAddressline2() != null) {
					HashMap<String, Object> address2 = new HashMap<>();
					address2.put("addressline2", "Enter valid addressline2");
					if (designerRequest.getAddressline2().isBlank())
						return new ResponseEntity<Object>(address2, HttpStatus.OK);
					else
						designer.setAddressline2(designerRequest.getAddressline2());

				}
				if (designerRequest.getLandmark() != null) {
					HashMap<String, Object> landmark = new HashMap<>();
					landmark.put("landmark", "Enter valid landmark");
					if (designerRequest.getLandmark().isBlank())
						return new ResponseEntity<Object>(landmark, HttpStatus.OK);
					else
						designer.setLandmark(designerRequest.getLandmark());

				}

				if (designerRequest.getCity() != null) {
					HashMap<String, Object> city = new HashMap<>();
					city.put("city", "Enter valid city");
					if (designerRequest.getCity().isBlank())
						return new ResponseEntity<Object>(city, HttpStatus.OK);
					else
						designer.setCity(designerRequest.getCity());
				}

				if (designerRequest.getState() != null) {
					HashMap<String, Object> state = new HashMap<>();
					state.put("state", "Enter valid state");
					if (designerRequest.getState().isBlank())
						return new ResponseEntity<Object>(state, HttpStatus.OK);
					else
						designer.setState(designerRequest.getState());
				}

				if (designerRequest.getCountry() != null) {
					HashMap<String, Object> country = new HashMap<>();
					country.put("country", "Enter valid country");
					if (designerRequest.getCountry().isBlank())
						return new ResponseEntity<Object>(country, HttpStatus.OK);
					else
						designer.setCountry(designerRequest.getCountry());
				}

				if (designerRequest.getPincode() != null) {
					HashMap<String, Object> pincode = new HashMap<>();
					pincode.put("pincode", "Enter valid pincode");
					if (designerRequest.getPincode().isBlank())
						return new ResponseEntity<Object>(pincode, HttpStatus.OK);
					else
						designer.setPincode(designerRequest.getPincode());
				}

				MultiValueMap<String, String> status = new HttpHeaders();
				status.add("status", "400");

				Designer designer2 = designerRepository.save(designer);
				return new ResponseEntity<>(designer2, status, HttpStatus.OK);

			} else {
				return null;// new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
			}
		} else {
			return null; // new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
	}
//----------------------------------------------------------------
//	 public void sendOTP(String to, String otp) {
//	        SimpleMailMessage message = new SimpleMailMessage();
//	        message.setTo(to);
//	        message.setSubject("OTP Verification");
//	        message.setText("Your OTP is: " + otp);
//
//	        javaMailSender.send(message);
//	    }
//----------------------------------------------------

	public void forgotPassword(String email) {
		Optional<Designer> optional = designerRepository.findByEmail(email);
		Designer designer = optional.get();

		if (designer.getIsdeleted() == 0) {
			String otp = generateOtp();

			// Store the OTP in the map
			otpMap.put(email, otp);

			// Send the OTP to the user's email
			sendOtpByEmail(email, otp);
		}
	}

	public boolean verifyOtpAndUpdatePassword(String email, String otp, String newPassword) {
		Optional<Designer> optional = designerRepository.findByEmail(email);

		Designer designer = optional.get();
		if (designer.getIsdeleted() == 0 && otpMap.containsKey(email) && otpMap.get(email).equals(otp)) {
			// Update the user's password
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			String encodePassword = bCryptPasswordEncoder.encode(newPassword);

			designer.setPassword(encodePassword);
			designerRepository.save(designer);

			// Remove the OTP from the map after successful verification
			otpMap.remove(email);

			return true;
		}

		return false;
	}

	private String generateOtp() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		return String.valueOf(otp);
	}

	private void sendOtpByEmail(String email, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("OTP Verification");
		message.setText("Your OTP is: " + otp);
		javaMailSender.send(message);
	}
}
