package com.bankapplicationcollections.main;
import java.io.IOException;
import java.util.Scanner;
import com.bankapplication.model.CustomerDetails;
import com.bankapplicationcollections.service.BankServiceImpl;

public class MainUI {
			
	void selection() {
		
		CustomerDetails custDetails = new CustomerDetails();
		BankServiceImpl bankService1 = new BankServiceImpl();
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Please enter your choice 1.Registration 2.Login 3.exit");
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("enter your first name");
				custDetails.setFirstName(input.next());
				System.out.println("enter your last name");
				custDetails.setLastName(input.next());
				System.out.println("enter your email id");
				custDetails.setEmailId(input.next());
				System.out.println("enter your password");
				custDetails.setPassword(input.next());
				System.out.println("enter your pan card number");
				custDetails.setPancardNo(input.next());
				System.out.println("enter your aadhar number");
				custDetails.setAadharNo(input.next());
				System.out.println("enter your address");
				custDetails.setAddress(input.next());
				System.out.println("enter your mobile number");
				custDetails.setMobileNo(input.next());

				custDetails.setBalance(0);
				custDetails = bankService1.registration(custDetails);
				
				if(custDetails.getAccountNo() != 0)
					System.out.println("you are successfully registered your account number is:"+custDetails.getAccountNo());
				else
				    System.out.println("not registered");
				break;
			
			case 2:
				System.out.println("enter your account number");
				long accountNo=input.nextLong();
				 
				System.out.println("enter password");
				String password=input.next();
				
				custDetails =  bankService1.login(accountNo,password);
				if(custDetails.getAccountNo() == -1) {
					System.out.println("not loggedin, password or account number is wrong");
				}else {
				System.out.println("login done successfully");
				System.out.println("enter your choice\n 1.deposit \n 2.withdraw \n 3.transfer\n 4.showBalance \n 5.exit");
			
				int ch = input.nextInt();
				switch(ch) {
				case 1:
					System.out.println("enter amount to deposit");
					int depositAmount = input.nextInt();
					int bal = bankService1.deposit(depositAmount, custDetails);
					System.out.println("total balance after deposit is:"+bal);
					break;
				case 2:
					System.out.println("enter amount to be withdrawn");
					int withdrawAmount = input.nextInt();
					int i= bankService1.withdraw(withdrawAmount, custDetails);
					if(i==1)
					System.out.println("total balance after withdraw is:"+custDetails.getBalance());
					break;
				case 3:
					System.out.println("enter amount to be transferred");
					int amountTransferred =input.nextInt();
					System.out.println("enter account number to which money should be transferred");
					long toAccount = input.nextInt();
					
					custDetails = bankService1.transfer(amountTransferred, custDetails, toAccount);
					if(custDetails != null) {
					System.out.println("successfully transffered");
					System.out.println("amount transferred is"+custDetails.getAmountTransferred());
					System.out.println("to account num"+custDetails.getToAccount());

					}		
					break;
				case 4:
					int totalBalance = bankService1.showBalance();
					System.out.println("your balance is"+totalBalance);
					break;
				case 5:
					System.exit(0);
				
				}
				}
			break;
			}
				
	}while(true);
		
	}
	
	public static void main(String[] args) throws IOException{
		MainUI uiObj = new MainUI();
		uiObj.selection();
	}

}
