package com.bankapplication.service;

import com.bankapplication.beans.Details;

public interface IBankService2 {
	int deposit(int depositAmount,int accountNo);
	int withdraw(int withdrawAmount,int accountNo);
	Details transfer(int amountTransferred,int accountNo,int toAccount);
	int showBalance(int accountNo);
}
