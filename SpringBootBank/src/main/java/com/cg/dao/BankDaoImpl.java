package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.model.CustomerDetails;

@Repository
@Component("bankDao")
public class BankDaoImpl implements BankDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public CustomerDetails register(CustomerDetails cd) {
		entityManager.persist(cd);
		return cd;
		
	}

	@Override
	public int login(CustomerDetails c) {
		int accountNo=0;
		CustomerDetails cd = entityManager.find(CustomerDetails.class, c.getAccountNo());
		if(cd.getPassword().equals(c.getPassword())) {
			accountNo = c.getAccountNo(); 
		}
		return accountNo;
	}
}
