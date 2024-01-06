package com.alexa.bank.apps.service;

import com.alexa.bank.apps.model.Customer;

public interface CustomerService {

	//save customer object into db
	void saveCustomer(Customer customer);
}
