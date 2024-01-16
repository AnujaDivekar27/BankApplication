package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.model.AccountDetails;
import com.alexa.bank.apps.service.AccountDetailsService;

@RestController
public class AccountCreationController {

	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@PostMapping(value = "/createAccount/{uname}")
	public String createAccount(@PathVariable String uname, @RequestBody AccountDetails accountDetails) {

		accountDetailsService.createAccount(uname, accountDetails);
		return "Account created successfully";
	}


}
