package com.alexa.bank.apps.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.dto.Balance;
import com.alexa.bank.apps.model.AccountDetails;
import com.alexa.bank.apps.model.Customer;
import com.alexa.bank.apps.model.RandomAcNumberGenerator;
import com.alexa.bank.apps.repo.AccountDetailsRepository;
import com.alexa.bank.apps.repo.CustomerRepository;
import com.alexa.bank.apps.repo.RandomAcNumberRepository;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService
{
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	private RandomAcNumberRepository randomAcNumberRepository;
	
	@Autowired
	private RandomAcNumberService randomAcNumberService;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void createAccount(String uname, AccountDetails accountDetails) {
		// TODO Auto-generated method stub
	
		System.out.println("Account creation started");

		if (accountDetails != null && uname != null) 
		{
	      Customer customer = customerRepository.findByUname(uname);

			if (customer != null) 
			{
			  RandomAcNumberGenerator randomAcNumberGenerator = randomAcNumberService.getRandomAcNumberData();
			
			  accountDetails.setAccountnumber("SBI:GEN"+String.valueOf(randomAcNumberGenerator.getAcnumber()));
			  accountDetails.setAcholdername(customer.getFirstname()+" "+customer.getLastname());
			  
			  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			  String date = dateFormat.format(new Date(System.currentTimeMillis()));
			
			  accountDetails.setAccountcreationdate(date);
			  
			  long acnumber1=randomAcNumberGenerator.getAcnumber()+1;
			  randomAcNumberGenerator.setAcnumber(acnumber1);
			  randomAcNumberRepository.save(randomAcNumberGenerator);
			  
			  //set date of account creation as accountbalance 1st TxtDate
			  accountDetails.getAccountBalance().setTxtDate(date);
			  accountDetails.getAccountBalance().setUname(uname);
			   
			  customer.getAccountDetails().add(accountDetails);
			  
			  customerRepository.save(customer);
			  
			} 
			else {
				System.out.println("customer not found...");	
			}
	    }
		System.out.println("Account creation end");
	}

	@Override
	public String creditBalance(String uname,String acno, Balance balance) {
	  
	  String msg="";	
	  String acNo="SBI/"+acno;
	  
	  if(acno!=null)
	  {	  
		AccountDetails accountDetails=accountDetailsRepository.findByAccountnumberAndAccounttype(acNo, balance.getAccounttype());
		if(accountDetails!=null)
		{
		   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		   String date = dateFormat.format(new Date(System.currentTimeMillis()));
			
		   accountDetails.getAccountBalance().setCreditamount(balance.getCreditAmount());
		   accountDetails.getAccountBalance().setTxtDate(date);
		   accountDetails.getAccountBalance().setUname(uname);
		   
		   if(balance.getCreditAmount()>0)
		   {	   
		     double totalBalance=accountDetails.getAccountBalance().getBalance();
		     accountDetails.getAccountBalance().setBalance(totalBalance+balance.getCreditAmount());
			  
		     accountDetailsRepository.save(accountDetails);
		     msg="Credit"; //return as msg
		   }
		   if(balance.getDebitAmount()>0)
		   {	   
			 double totalBalance=accountDetails.getAccountBalance().getBalance();
			 accountDetails.getAccountBalance().setBalance(totalBalance-balance.getDebitAmount());
				  
			 accountDetailsRepository.save(accountDetails);
			     
		     msg="Debit";
	       }
		else 
	    {
		  return "Account Details not found";   
        }
	  }
	 else
	 {
	    return "Account not exist";
	 }
	 		
	  return msg+"successfully";
	}
  }
	
}	