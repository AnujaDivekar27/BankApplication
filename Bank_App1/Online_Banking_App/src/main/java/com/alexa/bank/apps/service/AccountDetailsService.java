package com.alexa.bank.apps.service;

import com.alexa.bank.apps.dto.Balance;
import com.alexa.bank.apps.model.AccountDetails;

public interface AccountDetailsService 
{
   void createAccount(String uname, AccountDetails accountDetails);
   
   String creditBalance(String uname,String acno,Balance balance);
}
