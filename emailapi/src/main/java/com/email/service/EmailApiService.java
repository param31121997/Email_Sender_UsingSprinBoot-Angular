package com.email.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailApiService {
	
	public boolean sendEmail(String subject, String message, String to) {
		boolean flag = false;
		String from = "ramwankhede1997@gmail.com";
//		varibale for gmail
		String host = "smtp.gmail.com";
		
//		get the system properties
		Properties properties  = System.getProperties();
//		setting important properties
		
//		host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
//		step 1 : get the session object
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("ramwankhede1997@gmail.com","wxiy node lpla yrre\r\n");
			}
			
		});
		session.setDebug(true);
//		step 2 compose the message
		
		MimeMessage mimeMessage =  new MimeMessage(session);
		try {
//			from email
			mimeMessage.setFrom(from);
			
//			adding recipient to message
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
//			adding subject to message
			mimeMessage.setSubject(subject);
			
//			adding text to message
			mimeMessage.setText(message);
			
//			send
			
//			step 3 send the message using transport class
			Transport.send(mimeMessage);
			System.out.println("message send successfully");
			flag = true;
			
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return flag;
		
	}

}
