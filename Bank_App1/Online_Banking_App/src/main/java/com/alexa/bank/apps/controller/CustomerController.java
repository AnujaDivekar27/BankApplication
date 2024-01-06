package com.alexa.bank.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexa.bank.apps.model.Customer;
import com.alexa.bank.apps.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/save")
	public String saveCustomer(@RequestBody Customer customer)
	{
		System.out.println("------Customer details in controller------");
		System.out.println(customer);
		//send customer data from controller to service layer
		customerService.saveCustomer(customer);
		
		return "customer saved successfully.....";
	}
}
