package com.bankapplication.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapplication.beans.Details;

class BankDAO2Test {
	static BankDAO2 b;
	static Details d;
	@BeforeAll
	static void obj() {
		b= new BankDAO2();
		d = new Details();
	}
	@Test
	void testDeposit() {
	assertEquals(1900,b.deposit(1000, 100000413));
	}

	@Test
	void testWithdraw() {
	assertEquals(1800,b.withdraw(100, 100000413));
	}

	@Test
	void testTransfer() {		
		d.setAccountNo(100000413);
		
	assertEquals(d.getAccountNo(),(b.transfer(1000, 100000413,100000414)).getAccountNo());
	}

	@Test
	void testShowBalance() {
		assertEquals(1000,b.showBalance(100000414));
	}

	@Test
	void testValidateAccountNo() {
		assertEquals(true,b.validateAccountNo(100000414));
	}

}
