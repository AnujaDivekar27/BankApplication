package com.alexa.bank.apps.dto;

import com.alexa.bank.apps.model.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

  //dto->design pattern
  //dto->data transferring object,not class object not saved in database
  //class object used to send as response to after successful login of customer 

	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String uname;
	
	private String rolename;
}
