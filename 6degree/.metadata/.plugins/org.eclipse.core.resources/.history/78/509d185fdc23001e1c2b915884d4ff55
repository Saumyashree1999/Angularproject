package com.saumya.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saumya.demo.dto.Base;
import com.saumya.demo.entity.Subscriber;
import com.saumya.demo.repository.SubscriberRepository;
import com.saumya.demo.service.SubscriberService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/subscriber")
public class SubscriberController {

	@Autowired
	private SubscriberRepository subscriberRepository;

	@Autowired
	private SubscriberService subscriberService;

	@PostMapping("/subscribe")
	public ResponseEntity<Object> save(@Valid @RequestBody Base base) throws Throwable {
		if (base.getName() == null)
			return new ResponseEntity<>("name can't be null", HttpStatus.BAD_REQUEST);

		if (base.getEmail() == null)
			return new ResponseEntity<>("email can't be null", HttpStatus.BAD_REQUEST);

		if (subscriberRepository.existsByEmail(base.getEmail()))
			return new ResponseEntity<>("Email is already exist", HttpStatus.BAD_REQUEST);

		if (subscriberRepository.existsByMobilenumber(base.getMobilenumber()))
			return new ResponseEntity<>("mobile number already exists", HttpStatus.BAD_REQUEST);

		if (base.getMobilenumber() == null)
			return new ResponseEntity<>("enter valid number", HttpStatus.BAD_REQUEST);

//		Subscriber subscriber = subscriberService.save(base);
//		return new ResponseEntity<>(subscriber, HttpStatus.OK);

		MultiValueMap<String, String> status = new HttpHeaders();
		status.add("status", "200");
		Subscriber subscriber = subscriberService.save(base);
		return new ResponseEntity<>(subscriber, status, HttpStatus.OK);

	}

}

//	@PostMapping("/sendMail")
//	public String sendMail(@RequestBody Base base) {
//		String status = subscriberService.sendSimpleMail(base);
//
//		return status;
//	}

// Sending email with attachment
//	@PostMapping("/sendMailWithAttachment")
//	public String sendMailWithAttachment(@RequestBody Base base) {
//		String status = subscriberService.sendMailWithAttachment(base);
//
//		return status;
//	}
//	
//	@PostMapping("/sendMailWithLogo")
//	public String sendMailWithLogo(@RequestBody Base base) throws MessagingException {
//		String status = subscriberService.sendMailWithLogo(base);
//
//		return status;
//	}
