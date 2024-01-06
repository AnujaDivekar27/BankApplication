package com.alexa.bank.apps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexa.bank.apps.model.RandomAcNumberGenerator;

@Repository
public interface RandomAcNumberRepository extends JpaRepository<RandomAcNumberGenerator, Integer> 
{

}
