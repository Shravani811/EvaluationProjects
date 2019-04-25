package com.cg.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.cg.exceptions.withdrawException;
import com.cg.model.CustomerDetails;
import com.cg.model.TransactionDetails;

@Repository
public class TransactionDaoImpl implements TransactionDao {
	ArrayList<TransactionDetails> transList =  new ArrayList<TransactionDetails>();
	// TransactionDetails transaction1 = new TransactionDetails();
	int transId = 101;

	public int deposit(int accNo, ArrayList<CustomerDetails> custList, int amt) {
		// TODO Auto-generated method stub
		int amount = 0;
		System.out.println(accNo);
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == accNo) {
				 amount = customerDetails.getBalance()+amt;
				customerDetails.setBalance(amount);
			}
		}
		return amount;
	}

	public int withdraw(int accNo, ArrayList<CustomerDetails> custList, int amt) {
		// TODO Auto-generated method stub
		int amount = 0;
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == accNo) {
				if(customerDetails.getBalance()>amt) {
					amount = customerDetails.getBalance()-amt;
					customerDetails.setBalance(amount);
				}
				else {
					try {
						throw new withdrawException();
					} catch (withdrawException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return amount;
	}

	public int showBalance(int accNo, ArrayList<CustomerDetails> custList) {
		// TODO Auto-generated method stub
		int amount = 0;
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == accNo) {
				amount = customerDetails.getBalance();
			}
		}
		return amount;
	}

	public TransactionDetails fundTransfer(int accNo, TransactionDetails transaction,
			ArrayList<CustomerDetails> custList) {
		
		int amount = 0;
		for (CustomerDetails customerDetails : custList) {
			if(customerDetails.getAccountNo() == accNo) {
				for (CustomerDetails customerDetails1 : custList) {
					if(customerDetails1.getAccountNo() == transaction.getToAcc()) {
						if(customerDetails.getBalance()>transaction.getAmt()) {
							transaction.setFromAcc(accNo);
							transaction.setTransactionId(transId);
							
							transId++;
							amount = customerDetails.getBalance()-transaction.getAmt();
							customerDetails.setBalance(amount);
							 
							customerDetails1.setBalance(customerDetails1.getBalance()+transaction.getAmt());
							transList.add(transaction);
						}
					}
				}
			}
		}
		return transaction;
	}

	@Override
	public ArrayList<TransactionDetails> getAllTran() {
		
		
		return transList;
	}

	
}
