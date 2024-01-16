package com.alexa.bank.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.model.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails,Integer>
{
    AccountDetails findByAccountnumberAndAccounttype(String acno,String accounttype);
}
