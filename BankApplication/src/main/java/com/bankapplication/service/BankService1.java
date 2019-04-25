package com.bankapplication.service;

import com.bankapplication.beans.Details;
import com.bankapplication.dao.BankDAO1;
import com.bankapplication.dao.IBankDAO1;
import com.bankapplication.exception.InvalidAadharException;
import com.bankapplication.exception.InvalidMobileNoException;

public class BankService1 implements IBankService1{
	IBankDAO1 bankDao = new BankDAO1();

	
	public int registration(Details details) {
		//validation of mobile number
		if(details.getMobileNo().length() !=10) {
			try {
			throw new InvalidMobileNoException();
		}catch(Exception e) {
			
		}
		details=null;	
		}
		//validation of aadhar number
		if(details.getAadharNo().length() !=12) {
			try {
				throw new InvalidAadharException();
			}catch(Exception e) {
				
			}
		details=null;	
		}
    
		
		return bankDao.registration(details);
	
}
	public Details login(int accountNo,String password) {
		
		return bankDao.login(accountNo,password);
	}

	

	

}
