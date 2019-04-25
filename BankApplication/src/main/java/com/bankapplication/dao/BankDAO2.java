package com.bankapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bankapplication.beans.Details;
import com.bankapplication.utility.DataConnection;

public class BankDAO2<amountTransferred> implements IBankDAO2{
	Details details = new Details();
	DataConnection d = new DataConnection();
	Connection con = d.connect();
	//depositing money into particular account 
	public int deposit(int depositAmount,int accountNo) {
		int depositBalance=0;
		try {
			PreparedStatement st=con.prepareStatement("update customer set balance=balance+? where account_no=?");
				st.setInt(1, depositAmount);
				st.setInt(2, accountNo);
				
			int i = st.executeUpdate();
			
			if(i==1) {
				PreparedStatement statement=con.prepareStatement("select * from customer where account_no=?");
			
			statement.setLong(1, accountNo);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				depositBalance=resultSet.getInt(10);
			}
			}
			}catch(Exception e) {
				
				}
		
		
		return depositBalance;
	}
	//withdrawing money into particular account 
	public int withdraw(int withdrawAmount,int accountNo) {
		int withdrawBalance=0;
		try {
			
			PreparedStatement st=con.prepareStatement("update customer set balance=balance-? where account_no=? and balance>? ");
				st.setInt(1, withdrawAmount);
				st.setInt(2, accountNo);
				st.setInt(3, withdrawAmount);
			int i = st.executeUpdate();
			
			if(i==1) {
				PreparedStatement statement=con.prepareStatement("select * from customer where account_no=?");
			
			statement.setLong(1, accountNo);
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				withdrawBalance=resultSet.getInt(10);
			}
			}
			}catch(Exception e) {
				
				}
		return withdrawBalance;
		
	}
	//transfer of money from one account to another account
	public Details transfer(int amountTransferred,int accountNo,int toAccount) {
		if(validateAccountNo(toAccount))
		{
					try {
						
						PreparedStatement preparedStatement=con.prepareStatement("update customer set balance=balance-? where account_no=? and balance > ?");
						
						preparedStatement.setLong(1, amountTransferred);
						preparedStatement.setLong(2, accountNo);
						preparedStatement.setLong(3, amountTransferred);
						
						int i=preparedStatement.executeUpdate();
						
						if(i==1)
						{
							PreparedStatement preparedStatement2=con.prepareStatement("update customer set balance=balance+? where account_no=?");
							
							preparedStatement2.setLong(1, amountTransferred);
							preparedStatement2.setLong(2, toAccount);
							
							int j=preparedStatement2.executeUpdate();
							if(j==1)
							{
								PreparedStatement preparedStatement3=con.prepareStatement("insert into Transaction_table values(transno_seq.nextval,?,?,?)");
								
								preparedStatement3.setLong(1, accountNo);
								preparedStatement3.setLong(2, toAccount);
								preparedStatement3.setLong(3, amountTransferred);
								
								int k=preparedStatement3.executeUpdate();
								if(k==1)
								{
									PreparedStatement preparedStatement4=con.prepareStatement("select * from Transaction_table where from_account_no=?");
									
									preparedStatement4.setLong(1, accountNo);
									
									ResultSet resultSet=preparedStatement4.executeQuery();
									while(resultSet.next())
									{
										details.setTransactionID(resultSet.getString(1));
										details.setAccountNo(resultSet.getInt(2));
										details.setToAccount(resultSet.getInt(3));
										details.setAmountTransferred(resultSet.getInt(4));
										
										
									}
									
									
									
								}
								
							}
							
						}
						
						
						
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
					
		}
		return details;
		
	}
	//displaying money into particular account 
	public int showBalance(int accountNo) {
		int bal = 0;
		try {
		PreparedStatement st=con.prepareStatement("select * from customer where account_no=?");
		
		st.setInt(1, accountNo);
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			bal=rs.getInt(10);
		}
		}catch(Exception e) {
			
		}
		return bal;
	}
	boolean validateAccountNo(int accountNo) {
		boolean check=false;
	
		Statement statement;
		try {
			statement = con.createStatement();
			
			ResultSet resultSet=statement.executeQuery("select * from customer");
			while(resultSet.next())
			{
				if(resultSet.getLong(1)==accountNo)
				{
					check=true;
					break;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return check;
		
	}
}
