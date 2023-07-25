package com.saumya.demo.service;

import com.saumya.demo.dto.Base;
import com.saumya.demo.entity.Subscriber;

import jakarta.mail.MessagingException;

public interface SubscriberService {

	Subscriber save(Base base) throws Throwable;

	// To send a simple email
//	String sendSimpleMail(Base base);

	// To send an email with attachment
//	String sendMailWithAttachment(Base base);

	// To send an email To Subscriber
	String sendMailToSubscriber(Base base) throws MessagingException;

	// To send an email To Author
	String sendMailToAuthor(Base base) throws MessagingException;

}
