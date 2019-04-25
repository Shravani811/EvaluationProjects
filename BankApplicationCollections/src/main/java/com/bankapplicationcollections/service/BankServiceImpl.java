package com.bankapplicationcollections.service;

import com.bankapplication.exception.InvalidAadharException;
import com.bankapplication.exception.InvalidMobileNoException;
import com.bankapplication.model.CustomerDetails;

import com.bankapplicationcollections.dao.BankDaoImpl;
import com.bankapplicationcollections.dao.IBankDao;

public class BankServiceImpl implements IBankService {
	
	CustomerDetails customerDetails = new CustomerDetails();
	IBankDao bankDao = new BankDaoImpl();
	public CustomerDetails registration(CustomerDetails custDetails) {
		
		
		//validation of mobile number
				if(custDetails.getMobileNo().length() !=10) {
					try {
					throw new InvalidMobileNoException();
				}catch(Exception e) {
					
				}
					custDetails=null;	
				}
				//validation of aadhar number
				if(custDetails.getAadharNo().length() !=12) {
					try {
						throw new InvalidAadharException();
					}catch(Exception e) {
						
					}
					custDetails=null;	
				}
		    
		
		
		return bankDao.registration(custDetails);
}
	public CustomerDetails login(long accountNo, String password) {
		
		return bankDao.login(accountNo,password);
	}
	public int deposit(int depositAmount,CustomerDetails customerDetails) {
		
		return bankDao.deposit(depositAmount,customerDetails);
	}

	public int withdraw(int withdrawAmount,CustomerDetails customerDetails) {
		return bankDao.withdraw(withdrawAmount,customerDetails);
	}

	public CustomerDetails transfer(int amountTransferred,CustomerDetails customerDetails, long toAccount) {
		return bankDao.transfer(amountTransferred,customerDetails, toAccount);
	}

	public int showBalance() {
		return bankDao.showBalance();
	}

	
}
