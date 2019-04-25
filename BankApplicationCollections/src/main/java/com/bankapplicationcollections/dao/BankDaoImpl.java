package com.bankapplicationcollections.dao;
import java.util.HashMap;
import java.util.Map;
import com.bankapplication.model.CustomerDetails;

public class BankDaoImpl implements IBankDao {

	CustomerDetails customerDetails = new CustomerDetails();
	Map<Long,CustomerDetails> customerMap = new HashMap<Long,CustomerDetails>();
	long acc = 1000;
	//registering a customer
	public CustomerDetails registration(CustomerDetails customerDetails) {
		customerMap.put(acc+1, new CustomerDetails(customerDetails.getAadharNo(),
					customerDetails.getAddress(),customerDetails.getEmailId(),customerDetails.getFirstName(),
					customerDetails.getLastName(),customerDetails.getMobileNo(),customerDetails.getPancardNo(),
					customerDetails.getPassword()));
		acc=acc+1;
		customerDetails.setAccountNo(acc);
		return customerDetails;
	}

	//login
	public CustomerDetails login(long accountNo, String password) {
		
		if(customerMap.containsKey(accountNo)&&password.equals(customerMap.get(accountNo).getPassword())) {
			 customerDetails=customerMap.get(accountNo);
		 }else {
			 customerDetails.setAccountNo(-1);
		 }
		return customerDetails;
	}
	

	public int deposit(int depositAmount, CustomerDetails customerDetails) {
		customerDetails.setBalance(customerDetails.getBalance()+depositAmount);
        return customerDetails.getBalance(); 
	}



//withdraw
	public int withdraw(int withdrawAmount, CustomerDetails customerDetails) {
		int i = 0;
		if (withdrawAmount > customerDetails.getBalance()) {
		
		return 0;		
			} 		
	else {
					
		customerDetails.setBalance(customerDetails.getBalance()-withdrawAmount);
		
				return 1;
				
	}
	
	}


//transfer
	public CustomerDetails transfer(int amountTransferred,CustomerDetails customerDetails, long toAccount) {
		int i = 0;
		if (amountTransferred > customerDetails.getBalance()) {
			
		} else {
			customerDetails.setBalance(customerDetails.getBalance() - amountTransferred);
			for (Map.Entry<Long, CustomerDetails> me : customerMap.entrySet()) {
				if (toAccount == me.getKey()) {
					CustomerDetails details2 = me.getValue();
					details2.setBalance(details2.getBalance() + amountTransferred);
					i++;
				}
			}
		}

		if (i == 1) {
			customerDetails.setAmountTransferred(amountTransferred);
			customerDetails.setToAccount(toAccount);
			customerDetails.setFromAccount(customerDetails.getAccountNo());
			System.out.println(customerDetails.getAccountNo());
			return customerDetails;
		}
		else
			return null;
	}
	
//showing balance
	public int showBalance() {	
			return customerDetails.getBalance();
	}
	
	

	
}


