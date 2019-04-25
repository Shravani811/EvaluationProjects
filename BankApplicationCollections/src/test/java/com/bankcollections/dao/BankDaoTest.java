package com.bankcollections.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapplication.model.CustomerDetails;
import com.bankapplicationcollections.dao.BankDaoImpl;

class BankDaoTest {

	static CustomerDetails d;
	static CustomerDetails d1;
	static CustomerDetails d2;

	static BankDaoImpl b ;
	@BeforeAll
	public static void Obj() {
		d = new CustomerDetails();
		d1 = new CustomerDetails();
		d2 = new CustomerDetails();

		b = new BankDaoImpl();	
	}
	@Test
	void test() {
		d.setAadharNo("123654789654");
		d.setFirstName("smiley");
		d.setLastName("mukka");
		d.setEmailId("shravani@gmail.com");
		d.setPancardNo("44567");
		d.setMobileNo("845513");
		d.setAddress("hyd");
		d.setPassword("ss");
		d.setBalance(0);
		
		
		
		d1.setAadharNo("123654789654");
		d1.setFirstName("smiley");
		d1.setLastName("mukka");
		d1.setEmailId("shravani@gmail.com");
		d1.setPancardNo("44567");
		d1.setMobileNo("845513");
		d1.setAddress("hyd");
		d1.setPassword("ss");
		d1.setBalance(0);	


		assertEquals("845513",b.registration(d).getMobileNo());
		
	}
	@Test
	void login() {
		assertEquals(-1, b.login(1003, "ss").getAccountNo());
	}
	
	@Test
	void testDeposit() {
		d.setAccountNo(1001);
		assertEquals(100, b.deposit(100,d));
	}
	
	@Test
	void testWithdraw() {
		d.setAccountNo(1001);
		assertEquals(0, b.withdraw(50, d));
	}

	

		@Test
	void testFundTransfer() {
		
		d.setFromAccount(1001);
		d.setToAccount(1002);
		d.setAmountTransferred(1000);
		assertEquals(0,b.transfer(1000, d , 1002));
	}


	
	
	

}
