package com.alexa.bank.apps.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String accountnumber;
	
	private String acholdername;
	
	private String accounttype;
	
	private String accountcreationdate;
	
	private String bankname;
	
	private String bankifsccode;
	
	private String bankfax;
	
	private String bankemail;
	
	private String bankcontactno;
	
	private String bankbranchname;
	
	private String bankaddress;
	
	//AccountBalance table contains pri key id of AccountDetails table as fk
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "ac_detail_id")
	private AccountBalance accountBalance;


}
