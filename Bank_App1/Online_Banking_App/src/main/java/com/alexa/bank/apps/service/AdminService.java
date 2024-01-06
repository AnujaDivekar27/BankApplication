package com.alexa.bank.apps.service;

import java.util.List;

import com.alexa.bank.apps.model.Role;

public interface AdminService {

	//1:get all customers uname from Customer table   
	List<String> getAllUsersName();
	
	//2:get all role details from Role table for each role
	List<Role> getAllRoles();
	
	//3:assign role to uname
	void assignRole(String uname, Role role);
}
