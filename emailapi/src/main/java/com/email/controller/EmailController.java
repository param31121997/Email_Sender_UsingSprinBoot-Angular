package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailApiService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailApiService emaiApiService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "hello this is my email api";
	}
	
//	api to send email
	@PostMapping("/sendmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		System.out.println(request);
		boolean result = this.emaiApiService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		if(result) {
			return ResponseEntity.ok(new EmailResponse("Email is send successfully.."));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not send"));
//		this.emaiApiService.sendEmail(null, null, null)
	}

}
