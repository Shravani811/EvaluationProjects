package com.bankapplication.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapplication.beans.Details;

class BankDAO1Test {
	
	static Details d;
	static BankDAO1 b ;
	@BeforeAll
	public static void Obj() {
		d = new Details();
		b = new BankDAO1();	
	}
	
	//@Test
	void testRegistration() {
	d.setAadharNo("123456070879");
	d.setAddress("hyd");
	d.setFirstName("shravni");
	d.setMobileNo("1234567890");
	d.setLastName("jais");
	d.setEmailID("k@97");
	d.setPancardNo("12345678");
	d.setPassword("k");
	d.setBalance(0);
	assertEquals(100000416,b.registration(d));
	}

	@Test
	void testLogin() {
		
		assertEquals(100000413,(b.login(100000413, "f")).getAccountNo());
	}

}
