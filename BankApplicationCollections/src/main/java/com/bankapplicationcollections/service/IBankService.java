package com.bankapplicationcollections.service;

import com.bankapplication.model.CustomerDetails;

public interface IBankService {

	CustomerDetails registration(CustomerDetails custDetails);
	CustomerDetails login(long accountNo,String password);
	 
		int deposit(int depositAmount,CustomerDetails customerDetails);
		int withdraw(int withdrawAmount,CustomerDetails customerDetails);
		CustomerDetails transfer(int amountTransferred,CustomerDetails customerDetails,long toAccount);
		int showBalance();
}
