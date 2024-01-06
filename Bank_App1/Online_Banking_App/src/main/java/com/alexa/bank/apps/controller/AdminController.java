package com.alexa.bank.apps.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alexa.bank.apps.model.Role;
import com.alexa.bank.apps.service.AdminService;

@RestController
public class AdminController {

  @Autowired
  private AdminService adminService;
  
  @GetMapping(value="/allUnames")
  public List<String> getAllUsersName()
  {
	List<String> unames=adminService.getAllUsersName();
	
	return unames;
  }
  
  @GetMapping(value="/allRoles")
  public List<Role> getAllRolesList()
  {
	List<Role> rlist=adminService.getAllRoles();
	
	return rlist;
	  
  }
  
  @PostMapping(value="/assignRole/{uname}")
  public String assignRole(@PathVariable String uname,@RequestBody Role role)
  {
	System.out.println("Check data in adminController" + uname + " " + role);
	adminService.assignRole(uname, role);		
	
	return "role assign successfully...";
	  
  }
}
