package com.alexa.bank.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.alexa.bank.apps.model.RandomAcNumberGenerator;
import com.alexa.bank.apps.repo.RandomAcNumberRepository;

@Service
public class RandomAcNumberServiceImpl implements RandomAcNumberService
{

	@Autowired
	private RandomAcNumberRepository randomAcNumberRepository;

	@Override
	public RandomAcNumberGenerator getRandomAcNumberData() 
	{
	  List<RandomAcNumberGenerator> randomlist=randomAcNumberRepository.findAll();
		
	  return randomlist.get(0); //returns first randomAcNumber from randomlist
	}

}
