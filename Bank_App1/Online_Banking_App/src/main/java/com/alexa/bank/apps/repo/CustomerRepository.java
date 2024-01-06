package com.alexa.bank.apps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
   //1:custom query:find customer on the basis of uname and password provided
   //and matched with already present customer in database	
   
	Customer findByUnameAndPassword(String uname,String password);
	
	//2:get list of all customer's uname from db
	@Query("select uname from Customer")
	List<String> getAllUnames();

	//3:find customer from Customer table by uname
	Customer findByUname(String uname);
	
}

