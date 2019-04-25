package com.cg.service;


import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.dao.BankDao;
import com.cg.model.CustomerDetails;

@Transactional
@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	BankDao bankDao;
	
	public CustomerDetails setInfo() {
		// TODO Auto-generated method stub
		return bankDao.setInfo();
	}
	
	public CustomerDetails register(@RequestBody CustomerDetails cd) {
		// TODO Auto-generated method stub
		return bankDao.register(cd);
	}
	
	public int login(ArrayList<CustomerDetails> custList, CustomerDetails c) {
		// TODO Auto-generated method stub
		return bankDao.login(custList, c);
	}
	

}
