package com.bankapplication.dao;

import com.bankapplication.beans.Details;

public interface IBankDAO1 {
	 int registration(Details details);
	 Details login(int accountNo,String password);
}
