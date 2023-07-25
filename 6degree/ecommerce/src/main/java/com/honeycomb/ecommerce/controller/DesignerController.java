package com.honeycomb.ecommerce.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.honeycomb.ecommerce.dto.DesignerRequest;
import com.honeycomb.ecommerce.entity.Designer;
import com.honeycomb.ecommerce.repository.DesignerRepository;
import com.honeycomb.ecommerce.service.DesignerService;

import org.springframework.util.StringUtils;

@CrossOrigin
@RestController
@RequestMapping("/designer")

public class DesignerController {

	@Autowired
	private DesignerService designerService;

	@Autowired
	private DesignerRepository designerRepository;

	private Map<String, String> otpMap = new HashMap<>();

	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@Valid @RequestBody DesignerRequest designerRequest) {
		if (designerRequest.getName() == null) {

			return new ResponseEntity<>("name can't be null", HttpStatus.BAD_REQUEST);
		}
		if (designerRequest.getEmail() == null)
			return new ResponseEntity<>("email can't be null", HttpStatus.BAD_REQUEST);

		if (designerRepository.existsByEmail(designerRequest.getEmail()))
			return new ResponseEntity<>("Email is already exist", HttpStatus.BAD_REQUEST);

		if (designerRepository.existsByPassword(designerRequest.getPassword()))
			return new ResponseEntity<>("password already exist", HttpStatus.BAD_REQUEST);

		if (designerRequest.getPassword().length() < 6 && designerRequest.getPassword().length() > 10)
			return new ResponseEntity<>("password must be between 6 to 10 ", HttpStatus.BAD_REQUEST);

		if (designerRepository.existsByMobilenumber(designerRequest.getMobilenumber()))
			return new ResponseEntity<>("mobile number already exists", HttpStatus.BAD_REQUEST);

		if (designerRequest.getMobilenumber() == null)
			return new ResponseEntity<>("enter valid number", HttpStatus.BAD_REQUEST);

		if (designerRequest.getLandmark() == null)
			return new ResponseEntity<>("landmark can't be null", HttpStatus.BAD_REQUEST);

		if (designerRequest.getCity() == null)
			return new ResponseEntity<>("city can't be null", HttpStatus.BAD_REQUEST);

		if (designerRequest.getState() == null)
			return new ResponseEntity<>("state can't be null", HttpStatus.BAD_REQUEST);

		if (designerRequest.getCountry() == null)
			return new ResponseEntity<>("country can't be null", HttpStatus.BAD_REQUEST);

		if (designerRequest.getPincode() == null)
			return new ResponseEntity<>("pincode can't be null", HttpStatus.BAD_REQUEST);

//		Optional<Designer> findByEmail = designerRepository.findByEmail(designerRequest.getEmail());
//		if (findByEmail.isPresent())
//			return new ResponseEntity<String>("email already exists", HttpStatus.BAD_REQUEST);
		MultiValueMap<String, String> status = new HttpHeaders();
		status.add("status", "200");
		Designer designer = designerService.saveOrUpdateDesigner(designerRequest);
		return new ResponseEntity(designer, status, HttpStatus.OK);
	}
//-----------------------------------------------------------------------------
//	public ResponseEntity<String> signIn(@RequestBody DesignerRequest designerRequest){
//		String email = designerRepository.findByEmail(designerRequest.getEmail());
//		if(email!=null) {
//			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//			bCryptPasswordEncoder.matches(designerRequest.getPassword(),)
//		}

//-----------------------------------------------------------------
//	@PostMapping("/Login")
//	public String signIn(@RequestBody DesignerRequest designerRequest) {
//		return designerService.signIn(designerRequest);
//
//	}
//--------------------------------------------------------------------

	@PostMapping("/Login")
	public ResponseEntity<Object> signIn(@RequestBody DesignerRequest designerRequest) {
		return designerService.signIn(designerRequest);

	}
	// ------------------------------------------------------

	@PostMapping("/getalldesigner")
	public Iterable<Designer> getAllDesigner() {
		return designerService.listAll();
	}

	@PostMapping("/getbyid/{id}")
	public Designer getDesignerById(@PathVariable(name = "id") Long id) {
		return designerService.getDesignerById(id);
	}

	@PostMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteDesigner(@PathVariable("id") Long id) {
		String deleteDesigner = designerService.deleteDesigner(id);
		return ResponseEntity.ok(deleteDesigner);
	}

	@PostMapping("/updatebyid/{id}")
	public ResponseEntity<Object> updateDesigner(@PathVariable("id") Long id,
			@RequestBody DesignerRequest designerRequest) {
		ResponseEntity<Object> designer = designerService.update(id, designerRequest);
		if (designer != null) {
			return designer;
		} else {
//			String message = "De not found with ID: " + id;
			return new ResponseEntity<>("Deigner not found with ID: " + id, HttpStatus.BAD_REQUEST);
		}

	}

//------------------------------------
	// Helper method to generate a 6-digit OTP
//	private String generateOTP() {
//		Random random = new Random();
//		int otp = 100000 + random.nextInt(900000);
//		return String.valueOf(otp);
//	}
//
//	@PostMapping("/forgot-password")
//	public ResponseEntity<String> forgotPassword(@RequestParam String email) {
//		Optional<Designer> optional = designerRepository.findByEmail(email);
//		Designer designer = optional.get();
//		if (designer.getIsdeleted() == 1) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Designer not found");
//		}
//
//		// Generate OTP
//		String otp = generateOTP();
//
//		// Store the OTP in the map
//		otpMap.put(email, otp);
//
//		// Send OTP to the user's email
//		designerService.sendOTP(email, otp);
//
//		return ResponseEntity.ok("OTP sent to email for password reset");
//	}
//
//	@PostMapping("/verify-otp")
//	public ResponseEntity<String> verifyOTP(@RequestParam String email, @RequestParam String enteredOtp) {
//		Optional<Designer> optional = designerRepository.findByEmail(email);
//
//		Designer designer = optional.get();
//		if (designer.getIsdeleted() == 1) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Designer not found");
//		}
//
//		String otp = otpMap.get(email);
//
//		if (StringUtils.isEmpty(otp) || !otp.equals(enteredOtp)) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
//		}
//
//		// OTP verification successful, proceed with password reset logic
//
//		// Clear the OTP from the map
//		otpMap.remove(email);
//
//		return ResponseEntity.ok("OTP verification successful");
//	}
//-------------------------------------------------------

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody DesignerRequest designerRequest) {
		String email = designerRequest.getEmail();
		designerService.forgotPassword(email);
		return ResponseEntity.ok("OTP sent to email for password reset");
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtpAndUpdatePassword(@RequestParam String email, @RequestParam String otp,
			@RequestParam String newPassword) {
		boolean isVerified = designerService.verifyOtpAndUpdatePassword(email, otp, newPassword);
		if (isVerified) {
			return ResponseEntity.ok("Password reset successful");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
		}
	}

}
