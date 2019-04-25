package com.bankapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bankapplication.beans.Details;
import com.bankapplication.utility.DataConnection;

public class BankDAO1 implements IBankDAO1{
	Details details = new Details();
	DataConnection d = new DataConnection();
	Connection con = d.connect();
	int accountNo=0;
	//registeration of bank customers
	public int registration(Details details) {
		try {
		String stmt="insert into customer values(accountno_seq.NEXTVAL,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(stmt);
		
		 pst.setString(1, details.getFirstName());
		
		 pst.setString(2,details.getLastName());

		 pst.setString(3,details.getEmailID());

		 pst.setString(4,details.getPassword());
	
		 pst.setString(5,details.getPancardNo());
		
		 pst.setString(6,details.getAadharNo());
		 
		 pst.setString(7, details.getAddress());
		 
		 pst.setString(8, details.getMobileNo());
		 
		 pst.setInt(9,details.getBalance());
		 
		int i = pst.executeUpdate();
		//generating account number
		if(i==1) {
			PreparedStatement statement=con.prepareStatement("select * from customer where first_name=?");
			
			statement.setString(1, details.getFirstName());
			
			ResultSet resultSet=statement.executeQuery();
			
			while(resultSet.next())
			{
				
				accountNo=resultSet.getInt(1);
			}
			
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		 return accountNo;
	}
		

	//login of bank customers with account number and password
	public Details login(int accountNo,String password) {
		try {
		PreparedStatement st=con.prepareStatement("select * from customer where account_no=?");
			st.setInt(1, accountNo);
			
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
		if(password.contentEquals(rs.getString(5))) {
			details.setAccountNo(accountNo);
		}
		}
		}catch(Exception e) {
			
			}
		return details;
	}

}
