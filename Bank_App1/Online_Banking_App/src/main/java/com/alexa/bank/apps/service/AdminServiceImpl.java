package com.alexa.bank.apps.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.model.Customer;
import com.alexa.bank.apps.model.Role;
import com.alexa.bank.apps.repo.CustomerRepository;
import com.alexa.bank.apps.repo.RoleRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private RoleRepository roleRepository;
  
  @Override
  public List<String> getAllUsersName() 
  {
	List<String> unamelist=customerRepository.getAllUnames(); 
	if(unamelist.size()>0)
	{
	 return unamelist;
    }
    
	else 
	{
	  return null;	
	}
  }

  @Override
  public List<Role> getAllRoles() 
  {
    //get all role details from Role table for each role
	List<Role> rolelist=roleRepository.findAll();
	
	return rolelist;
  }

  @Override
  public void assignRole(String uname, Role role) 
  {
	if(uname!=null)
	{
	  Customer customer=customerRepository.findByUname(uname);	
	  
	  //assign role to customer
	  customer.setRole(role);
	  
	  //save customer in database Customer table
	  customerRepository.save(customer);
	  
	}
  }
  
}
