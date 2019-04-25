package com.bankapplication.service;

import com.bankapplication.beans.Details;

public interface IBankService1 {
	 int registration(Details details);
	 Details login(int accountNo,String password);
}
