package com.bankapplication.UI;

import java.util.Scanner;

import com.bankapplication.beans.Details;
import com.bankapplication.exception.InsufficientBalanceException;
import com.bankapplication.service.BankService1;
import com.bankapplication.service.BankService2;

public class Client {
	public void bankOperation() {
		Details details = new Details();
		BankService1 bs = new BankService1();
		BankService2 bs2 = new BankService2();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter your choice 1.Registration 2.Login");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			System.out.println("enter your first name");
			details.setFirstName(input.next());
			System.out.println("enter your last name");
			details.setLastName(input.next());
			System.out.println("enter your email id");
			details.setEmailID(input.next());
			System.out.println("enter your password");
			details.setPassword(input.next());
			System.out.println("enter your pan card number");
			details.setPancardNo(input.next());
			System.out.println("enter your aadhar number");
			details.setAadharNo(input.next());
			System.out.println("enter your address");
			details.setAddress(input.next());
			System.out.println("enter your mobile number");
			details.setMobileNo(input.next());

			details.setBalance(0);
			int accNo = bs.registration(details);
			if(accNo!=0)
				System.out.println("you are successfully registered your account number is:"+accNo);
			else
			    System.out.println("not registered");
			
		case 2:
			System.out.println("enter your account number");
			details.setAccountNo(input.nextInt());
			int accountNo= details.getAccountNo();
			
			System.out.println("enter password");
			details.setPassword(input.next());
			String password=details.getPassword();
			
			details = bs.login(accountNo,password);
			if(accountNo!=0) {
			System.out.println("login done successfully,your login account number is:"+accountNo);
			}
			do {
			System.out.println("enter your choice\n 1.deposit \n 2.withdraw \n 3.transfer\n 4.showBalance \n 5.exit");
			int ch = input.nextInt();
			switch(ch) {
			case 1:
				System.out.println("enter amount to deposit");
				int depositAmount = input.nextInt();
				int balance = bs2.deposit(depositAmount, accountNo);
				System.out.println("total balance after deposit is:"+balance);
				break;
			case 2:
				System.out.println("enter amount to be withdrawn");
				int withdrawAmount = input.nextInt();
				int bal = bs2.withdraw(withdrawAmount, accountNo);
				if(bal!=0)
				System.out.println("total balance after withdraw is:"+bal);
				else {
					try {
					throw new InsufficientBalanceException();
					}catch(Exception e) {
						
					}
				}
				break;
			case 3:
				System.out.println("enter amount to be transferred");
				details.setAmountTransferred(input.nextInt());
				int amountTransferred = details.getAmountTransferred();
				
				System.out.println("enter account number to which money should be transferred");
				details.setToAccount(input.nextInt());
				int toAccount = details.getToAccount();
				
				details = bs2.transfer(amountTransferred, accountNo, toAccount);
				
						System.out.println("transaction id is :"+details.getTransactionID());
						System.out.println("from account number:"+accountNo);
						System.out.println("to account number  is:"+details.getToAccount());
						System.out.println("amount transferred is:"+amountTransferred);
						
						
				break;
			case 4:
				int totalBalance = bs2.showBalance(accountNo);
				System.out.println("your balance is"+totalBalance);
				break;
			case 5:
				System.exit(0);
			
			}
			
		}while(true);
		}
	}

	public static void main(String[] args) {
		Client clientObj = new Client();
		clientObj.bankOperation();
	}

}
