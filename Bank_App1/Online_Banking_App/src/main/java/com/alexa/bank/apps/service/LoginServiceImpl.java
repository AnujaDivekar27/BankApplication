package com.alexa.bank.apps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.dto.CustomerResponse;
import com.alexa.bank.apps.model.Customer;
import com.alexa.bank.apps.repo.CustomerRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository CustomerRepository;
	
	@Override
	public CustomerResponse getLoginData(String uname, String password) 
	{
    
	 CustomerResponse customerResponse=new CustomerResponse();	  	

	 //get customer from db where uname and password entered by Customer matched with db 
	 Customer customer=CustomerRepository.findByUnameAndPassword(uname, password);
	 if(customer!=null)
	 {
		//set customerResponse after login with uname and password 
		customerResponse.setId(customer.getId());
		customerResponse.setFirstname(customer.getFirstname());
		customerResponse.setLastname(customer.getLastname());
		customerResponse.setUname(customer.getUname());
		
		if(customer.getRole() != null) {
		 customerResponse.setRolename(customer.getRole().getRolename());
		}
	 }	
	 return customerResponse;
	}
 }
