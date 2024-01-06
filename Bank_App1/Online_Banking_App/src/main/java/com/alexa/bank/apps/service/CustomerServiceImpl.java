package com.alexa.bank.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.model.Customer;
import com.alexa.bank.apps.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void saveCustomer(Customer customer) {
	
	 System.out.println("------Customer details in service layer------");
     System.out.println(customer);
		
	 //save customer in database
     customerRepository.save(customer);
	}
	
	
}
