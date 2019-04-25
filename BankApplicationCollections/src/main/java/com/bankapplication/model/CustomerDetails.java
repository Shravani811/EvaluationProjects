package com.bankapplication.model;

public class CustomerDetails {
	
	private long accountNo;
	private String firstName;
	private String lastName;
	private String emailId;
	private String  password;
	private String pancardNo;
	private String aadharNo;
	private String address;
	private String mobileNo;
	private int balance;
	private long fromAccount,toAccount;
	private int amountTransferred;
	
	public CustomerDetails() {
		
	}
	public CustomerDetails(String aadharNo, String address, String emailId, String firstName, String lastName,
			String mobileNo, String pancardNo, String password) {
		this.aadharNo = aadharNo;
		this.address = address;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.pancardNo = pancardNo;
		this.password = password;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPancardNo() {
		return pancardNo;
	}
	public void setPancardNo(String pancardNo) {
		this.pancardNo = pancardNo;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public int getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(int amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	
}
