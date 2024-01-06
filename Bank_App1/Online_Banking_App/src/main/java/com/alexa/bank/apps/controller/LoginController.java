package com.alexa.bank.apps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.dto.CustomerResponse;

@RestController
public class LoginController {

	@GetMapping(value="/login/{uname}/{password}")
	public CustomerResponse getLoginData(@PathVariable String uname,@PathVariable String password)
	{
	  System.out.println("------Login credentials in login controller------");
	  System.out.println("uname:"+" "+uname+" "+"password:"+" "+password);	
	  
	  return new CustomerResponse();
		
	}
}
