package com.security.assignment.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class UserController {

	@PostMapping("/hello")
	public String getToken() {
		return "Credit Limit validated";
	}
}
